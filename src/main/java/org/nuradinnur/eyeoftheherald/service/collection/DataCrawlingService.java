package org.nuradinnur.eyeoftheherald.service.collection;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.Queues;
import org.nuradinnur.eyeoftheherald.constant.Regions;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.leaguelist.LeagueItemDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.match.MatchDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.match.ParticipantIdentityDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.matchlist.MatchListDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.summoner.SummonerDTO;
import org.nuradinnur.eyeoftheherald.service.GameVersioningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class DataCrawlingService {

    private final Logger logger;
    private final DataCollectionService dataCollectionService;
    private final GameVersioningService gameVersioningService;

    public DataCrawlingService(DataCollectionService dataCollectionService, GameVersioningService gameVersioningService) {
        this.gameVersioningService = gameVersioningService;
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.dataCollectionService = dataCollectionService;
    }

    @Async
    public void start(Regions region) {
        Thread.currentThread().setName("Crawler-" + region.name());
        crawl(region);
    }

    private void crawl(Regions region) {
        val matches = new HashSet<MatchDTO>();
        val matchLists = new HashMap<ParticipantIdentityDTO, MatchListDTO>();

        // Initialize with challenger match lists.
        val challengerMatchLists = getChallengerMatchLists(region);
        logger.info("Found {} match lists for all challenger summoners in {}.",
                challengerMatchLists.size(), region.name());

        // For each challenger, get matches in list.
        for (val summoner : challengerMatchLists.keySet()) {
            val matchList = challengerMatchLists.get(summoner);
            val foundMatches = getMatchesForMatchList(region, matchList);
            matches.addAll(foundMatches);
            logger.info("Found {} matches for summoner {}.",
                    foundMatches.size(), summoner.getName(), region.name());
        }
        challengerMatchLists.clear();

        while (true) {
            // For each match collected, gather match participants' match lists.
            logger.info("Entering main loop.");
            for (val match : matches) {
                while (matchLists.size() < 100) {
                    val foundMatchLists = getMatchListsForParticipants(region, match);
                    matchLists.putAll(foundMatchLists);
                    logger.info("Found {} match lists in game {}.",
                            foundMatchLists.size(),
                            match.getGameId());
                }
            }
            // For each match list collected, get matches in list.
            for (val summoner : matchLists.keySet()) {
                val matchList = matchLists.get(summoner);
                val foundMatches = getMatchesForMatchList(region, matchList);
                matches.addAll(foundMatches);
                logger.info("Found {} matches for summoner {}.",
                        foundMatches.size(), summoner.getPlayer().getSummonerName());
            }
            matchLists.clear();
            // Continue forever...
        }
    }

    private HashMap<SummonerDTO, MatchListDTO> getChallengerMatchLists(Regions region) {
        val challengers = new HashSet<LeagueItemDTO>();
        challengers.addAll(dataCollectionService.getChallengerLeague(region, Queues.RANKED_SOLO_5x5).getEntries());
        challengers.addAll(dataCollectionService.getChallengerLeague(region, Queues.RANKED_FLEX_SR).getEntries());
        val result = new HashMap<SummonerDTO, MatchListDTO>();
        for (val challenger : challengers) {
            val summonerInfo = dataCollectionService.getSummonerByName(region, challenger.getPlayerOrTeamName());
            if (summonerInfo.getAccountId() != null) {
                val matchList = dataCollectionService.getMatchList(region, summonerInfo.getAccountId().toString());
                result.put(summonerInfo, matchList);
                logger.info("Found {} matches for {}.", matchList.getMatches().size(), summonerInfo.getName());
            }
            if (result.size() >= 100) {
                break;
            }
        }
        return result;
    }

    private HashMap<ParticipantIdentityDTO, MatchListDTO> getMatchListsForParticipants(Regions region, MatchDTO match) {
        val result = new HashMap<ParticipantIdentityDTO, MatchListDTO>();
        for (val participant : match.getParticipantIdentities()) {
            val accountId = participant.getPlayer().getAccountId();
            val matchList = dataCollectionService.getMatchList(region, accountId.toString());
            result.put(participant, matchList);
        }
        return result;
    }

    private Set<MatchDTO> getMatchesForMatchList(Regions region, MatchListDTO matchList) {
        val result = new HashSet<MatchDTO>();
        for (val reference : matchList.getMatches()) {
            val gameId = reference.getGameId();
            val match = dataCollectionService.getMatch(region, gameId.toString());
            if (!gameVersioningService.isCurrentPatch(match.getGameVersion())) {
                break;
            }
            result.add(match);
        }
        return result;
    }
}
