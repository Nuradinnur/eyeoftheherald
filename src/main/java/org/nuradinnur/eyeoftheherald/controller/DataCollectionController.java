package org.nuradinnur.eyeoftheherald.controller;

import org.nuradinnur.eyeoftheherald.constant.RankedQueues;
import org.nuradinnur.eyeoftheherald.constant.Regions;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.championmastery.ChampionMasteryDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.championrotation.ChampionRotationDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame.CurrentGameInfoDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame.FeaturedGamesDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.leaguelist.LeagueItemDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.leaguelist.LeagueListDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.match.MatchDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.matchlist.MatchListDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.matchtimeline.MatchTimelineDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.shardstatus.ShardStatusDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.summoner.SummonerDTO;
import org.nuradinnur.eyeoftheherald.service.collection.DataCollectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@ResponseBody
@RequestMapping(value = "/api/{region}")
public class DataCollectionController {

    private final DataCollectionService dataCollectionService;

    public DataCollectionController(DataCollectionService dataCollectionService) {
        this.dataCollectionService = dataCollectionService;
    }

    @GetMapping("/summoner/{summonerId}/mastery")
    public List<ChampionMasteryDTO> getAllChampionMasteries(@PathVariable("region") Regions region,
                                                            @PathVariable("summonerId") String summonerId) {
        return dataCollectionService.getAllChampionMasteries(region, summonerId);
    }

    @GetMapping("/summoner/{summonerId}/mastery/{championId}")
    public ChampionMasteryDTO getChampionMastery(@PathVariable("region") Regions region,
                                                 @PathVariable("summonerId") String summonerId,
                                                 @PathVariable("championId") String championId) {
        return dataCollectionService.getChampionMastery(region, summonerId, championId);
    }

    @GetMapping("/summoner/{summonerId}/mastery/score")
    public Integer getChampionMasteryScore(@PathVariable("region") Regions region,
                                           @PathVariable("summonerId") String summonerId) {
        return dataCollectionService.getChampionMasteryScore(region, summonerId);
    }

    @GetMapping("/rotation")
    public ChampionRotationDTO getChampionRotation(@PathVariable("region") Regions region) {
        return dataCollectionService.getChampionRotation(region);
    }

    @GetMapping("/leagues/challenger/{queue}")
    public LeagueListDTO getChallengerLeague(@PathVariable("region") Regions region,
                                             @PathVariable("queue") RankedQueues queue) {
        return dataCollectionService.getChallengerLeague(region, queue);
    }

    @GetMapping("/leagues/{leagueId}")
    public LeagueListDTO getLeague(@PathVariable("region") Regions region,
                                   @PathVariable("leagueId") String leagueId) {
        return dataCollectionService.getLeague(region, leagueId);
    }

    @GetMapping("/leagues/master/{queue}")
    public LeagueListDTO getMasterLeague(@PathVariable("region") Regions region,
                                         @PathVariable("queue") RankedQueues queue) {
        return dataCollectionService.getMasterLeague(region, queue);
    }

    @GetMapping("/summoner/{summonerId}/leagues")
    public Set<LeagueItemDTO> getLeaguePosition(@PathVariable("region") Regions region,
                                                @PathVariable("summonerId") String summonerId) {
        return dataCollectionService.getLeaguePosition(region, summonerId);
    }

    @GetMapping("/service-status")
    public ShardStatusDTO getServiceStatus(@PathVariable("region") Regions region) {
        return dataCollectionService.getServiceStatus(region);
    }

    @GetMapping("/match/{matchId}")
    public MatchDTO getMatch(@PathVariable("region") Regions region,
                             @PathVariable("matchId") String matchId) {
        return dataCollectionService.getMatch(region, matchId);
    }

    @GetMapping("/summoner/{accountId}/matches")
    public MatchListDTO getMatchList(@PathVariable("region") Regions region,
                                     @PathVariable("accountId") String accountId) {
        return dataCollectionService.getMatchList(region, accountId);
    }

    @GetMapping("/match/{matchId}/timeline")
    public MatchTimelineDTO getMatchTimeline(@PathVariable("region") Regions region,
                                             @PathVariable("matchId") String matchId) {
        return dataCollectionService.getMatchTimeline(region, matchId);
    }

    @GetMapping("/summoner/{summonerId}/spectate")
    public CurrentGameInfoDTO getCurrentGame(@PathVariable("region") Regions region,
                                             @PathVariable("summonerId") String summonerId) {
        return dataCollectionService.getCurrentGame(region, summonerId);
    }

    @GetMapping("/featured-games")
    public FeaturedGamesDTO getFeaturedGames(@PathVariable("region") Regions region) {
        return dataCollectionService.getFeaturedGames(region);
    }

    @GetMapping("/summoner/{accountId}/by-account-id")
    public SummonerDTO getSummonerByAccountId(@PathVariable("region") Regions region,
                                              @PathVariable("accountId") String accountId) {
        return dataCollectionService.getSummonerByAccountId(region, accountId);
    }

    @GetMapping("/summoner/{summonerName}/by-name")
    public SummonerDTO getSummonerByName(@PathVariable("region") Regions region,
                                         @PathVariable("summonerName") String summonerName) {
        return dataCollectionService.getSummonerByName(region, summonerName);
    }

    @GetMapping("/summoner/{summonerId}/by-summoner-id")
    public SummonerDTO getSummonerBySummonerId(@PathVariable("region") Regions region,
                                               @PathVariable("summonerId") String summonerId) {
        return dataCollectionService.getSummonerBySummonerId(region, summonerId);
    }

    @GetMapping("/verification/{summonerId}")
    public String getThirdPartyCode(@PathVariable("region") Regions region,
                                    @PathVariable("summonerId") String summonerId) {
        return dataCollectionService.getThirdPartyCode(region, summonerId);
    }
}
