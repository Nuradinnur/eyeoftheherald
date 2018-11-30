package org.nuradinnur.eyeoftheherald.service.collection;

import lombok.val;
import org.nuradinnur.eyeoftheherald.component.DataCollectionInterface;
import org.nuradinnur.eyeoftheherald.constant.Endpoints;
import org.nuradinnur.eyeoftheherald.constant.Queues;
import org.nuradinnur.eyeoftheherald.constant.Regions;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.championmastery.ChampionMasteryDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.championrotation.ChampionRotationDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame.CurrentGameDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame.FeaturedGamesDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.leaguelist.LeagueItemDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.leaguelist.LeagueListDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.match.MatchDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.matchlist.MatchListDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.matchtimeline.MatchTimelineDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.shardstatus.ShardStatusDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.summoner.SummonerDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class DataCollectionService {

    private final DataCollectionInterface dataCollectionInterface;

    public DataCollectionService(DataCollectionInterface dataCollectionInterface) {
        this.dataCollectionInterface = dataCollectionInterface;
    }

    public List<ChampionMasteryDTO> getAllChampionMasteries(Regions region, String summonerId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("summonerId", summonerId);
        return dataCollectionInterface.makeRequest(region, Endpoints.ALL_CHAMPION_MASTERIES, pathParameters, null, new ParameterizedTypeReference<List<ChampionMasteryDTO>>() {
        });
    }

    public ChampionMasteryDTO getChampionMastery(Regions region, String summonerId, String championId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("summonerId", summonerId);
        pathParameters.put("championId", championId);
        return dataCollectionInterface.makeRequest(region, Endpoints.CHAMPION_MASTERY, pathParameters, null, new ParameterizedTypeReference<ChampionMasteryDTO>() {
        });
    }

    public Integer getChampionMasteryScore(Regions region, String summonerId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("summonerId", summonerId);
        return dataCollectionInterface.makeRequest(region, Endpoints.TOTAL_MASTERY_SCORE, pathParameters, null, new ParameterizedTypeReference<Integer>() {
        });
    }

    public ChampionRotationDTO getChampionRotation(Regions region) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        return dataCollectionInterface.makeRequest(region, Endpoints.TOTAL_MASTERY_SCORE, pathParameters, null, new ParameterizedTypeReference<ChampionRotationDTO>() {
        });
    }

    public LeagueListDTO getChallengerLeague(Regions region, Queues queue) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("queue", queue.getName());
        return dataCollectionInterface.makeRequest(region, Endpoints.CHALLENGER_LEAGUE, pathParameters, null, new ParameterizedTypeReference<LeagueListDTO>() {
        });
    }

    public LeagueListDTO getLeague(Regions region, String leagueId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("leagueId", leagueId);
        return dataCollectionInterface.makeRequest(region, Endpoints.LEAGUE, pathParameters, null, new ParameterizedTypeReference<LeagueListDTO>() {
        });
    }

    public LeagueListDTO getMasterLeague(Regions region, Queues queue) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("queue", queue.getName());
        return dataCollectionInterface.makeRequest(region, Endpoints.MASTER_LEAGUE, pathParameters, null, new ParameterizedTypeReference<LeagueListDTO>() {
        });
    }

    public Set<LeagueItemDTO> getLeaguePosition(Regions region, String summonerId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("summonerId", summonerId);
        return dataCollectionInterface.makeRequest(region, Endpoints.LEAGUE_POSITION, pathParameters, null, new ParameterizedTypeReference<Set<LeagueItemDTO>>() {
        });

    }

    public ShardStatusDTO getServiceStatus(Regions region) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        return dataCollectionInterface.makeRequest(region, Endpoints.SERVICE_STATUS, pathParameters, null, new ParameterizedTypeReference<ShardStatusDTO>() {
        });
    }

    public MatchDTO getMatch(Regions region, String matchId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("matchId", matchId);
        return dataCollectionInterface.makeRequest(region, Endpoints.MATCH, pathParameters, null, new ParameterizedTypeReference<MatchDTO>() {
        });
    }

    public MatchListDTO getMatchListByQueue(Regions region, String accountId, List<String> queues) {
        val queryParameters = new LinkedMultiValueMap<String, String>();
        queryParameters.put("queue", queues);
        return getMatchList(region, accountId, queryParameters);
    }

    public MatchListDTO getMatchListBySeason(Regions region, String accountId, List<String> seasons) {
        val queryParameters = new LinkedMultiValueMap<String, String>();
        queryParameters.put("season", seasons);
        return getMatchList(region, accountId, queryParameters);
    }


    public MatchListDTO getPaginatedMatchList(Regions region, String accountId, int page) {
        val beginIndex = String.valueOf(page * 20);
        val endIndex = String.valueOf((page + 1) * 20);
        val queryParameters = new LinkedMultiValueMap<String, String>();
        queryParameters.put("beginIndex", new ArrayList<>());
        queryParameters.put("endIndex", new ArrayList<>());
        queryParameters.get("beginIndex").add(beginIndex);
        queryParameters.get("endIndex").add(endIndex);
        return getMatchList(region, accountId, queryParameters);
    }

    public MatchListDTO getMatchList(Regions region, String accountId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("accountId", accountId);
        return dataCollectionInterface.makeRequest(region, Endpoints.MATCH_LIST, pathParameters, null, new ParameterizedTypeReference<MatchListDTO>() {
        });
    }

    private MatchListDTO getMatchList(Regions region, String accountId, LinkedMultiValueMap<String, String> queryParameters) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("accountId", accountId);
        return dataCollectionInterface.makeRequest(region, Endpoints.MATCH_LIST, pathParameters, queryParameters, new ParameterizedTypeReference<MatchListDTO>() {
        });
    }

    public MatchTimelineDTO getMatchTimeline(Regions region, String matchId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("matchId", matchId);
        return this.dataCollectionInterface.makeRequest(region, Endpoints.TIMELINE, pathParameters, null, new ParameterizedTypeReference<MatchTimelineDTO>() {
        });
    }

    public CurrentGameDTO getCurrentGame(Regions region, String summonerId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("summonerId", summonerId);
        return dataCollectionInterface.makeRequest(region, Endpoints.CURRENT_GAME, pathParameters, null, new ParameterizedTypeReference<CurrentGameDTO>() {
        });
    }

    public FeaturedGamesDTO getFeaturedGames(Regions region) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        return dataCollectionInterface.makeRequest(region, Endpoints.FEATURED_GAMES, pathParameters, null, new ParameterizedTypeReference<FeaturedGamesDTO>() {
        });
    }

    public SummonerDTO getSummonerByAccountId(Regions region, String accountId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("accountId", accountId);
        return dataCollectionInterface.makeRequest(region, Endpoints.SUMMONER_BY_ACCOUNT_ID, pathParameters, null, new ParameterizedTypeReference<SummonerDTO>() {
        });
    }

    public SummonerDTO getSummonerByName(Regions region, String summonerName) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("summonerName", summonerName);
        return dataCollectionInterface.makeRequest(region, Endpoints.SUMMONER_BY_NAME, pathParameters, null, new ParameterizedTypeReference<SummonerDTO>() {
        });
    }

    public SummonerDTO getSummonerBySummonerId(Regions region, String summonerId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("summonerId", summonerId);
        return dataCollectionInterface.makeRequest(region, Endpoints.SUMMONER_BY_SUMMONER_ID, pathParameters, null, new ParameterizedTypeReference<SummonerDTO>() {
        });
    }

    public String getThirdPartyCode(Regions region, String summonerId) {
        val pathParameters = new HashMap<String, String>();
        pathParameters.put("region", region.getPlatform());
        pathParameters.put("summonerId", summonerId);
        return dataCollectionInterface.makeRequest(region, Endpoints.THIRD_PARTY_CODE, pathParameters, null, new ParameterizedTypeReference<String>() {
        });
    }
}
