package org.nuradinnur.eyeoftheherald.constant;

import lombok.Getter;
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

@Getter
public enum Endpoints {

    // DATA-DRAGON
    GAME_VERSIONS("/api/versions.json", String.class),
    STATIC_DATA_TARBALL("/cdn/dragontail-{gameVersion}.tgz", Object.class),

    // CHAMPION-MASTERY-V3
    ALL_CHAMPION_MASTERIES("/lol/champion-mastery/v3/champion-masteries/by-summoner/{summonerId}", ChampionMasteryDTO.class),
    CHAMPION_MASTERY("/lol/champion-mastery/v3/champion-masteries/by-summoner/{summonerId}/by-champion/{championId}", ChampionMasteryDTO.class),
    TOTAL_MASTERY_SCORE("/lol/champion-mastery/v3/scores/by-summoner/{summonerId}", Integer.class),

    // CHAMPION-V3
    CHAMPION_ROTATION("/lol/platform/v3/champion-rotations", ChampionRotationDTO.class),

    // LEAGUE-V3
    CHALLENGER_LEAGUE("/lol/league/v3/challengerleagues/by-queue/{queue}", LeagueListDTO.class),
    LEAGUE("/lol/league/v3/leagues/{leagueId}", LeagueListDTO.class),
    MASTER_LEAGUE("/lol/league/v3/masterleagues/by-queue/{queue}", LeagueListDTO.class),
    LEAGUE_POSITION("/lol/league/v3/positions/by-summoner/{summonerId}", LeagueItemDTO.class),

    // LOL-STATUS-V3
    SERVICE_STATUS("/lol/status/v3/shard-data", ShardStatusDTO.class),

    // MATCH-V3
    MATCH("/lol/match/v3/matches/{matchId}", MatchDTO.class),
    MATCH_LIST("/lol/match/v3/matchlists/by-account/{accountId}", MatchListDTO.class),
    TIMELINE("/lol/match/v3/timelines/by-match/{matchId}", MatchTimelineDTO.class),

    // SPECTATOR-V3
    CURRENT_GAME("/lol/spectator/v3/active-games/by-summoner/{summonerId}", CurrentGameDTO.class),
    FEATURED_GAMES("/lol/spectator/v3/featured-games", FeaturedGamesDTO.class),

    // SUMMONER-V3
    SUMMONER_BY_ACCOUNT_ID("/lol/summoner/v3/summoners/by-account/{accountId}", SummonerDTO.class),
    SUMMONER_BY_NAME("/lol/summoner/v3/summoners/by-name/{summonerName}", SummonerDTO.class),
    SUMMONER_BY_SUMMONER_ID("/lol/summoner/v3/summoners/by-name/{summonerName}", SummonerDTO.class),

    // THIRD-PARTY-CODE-V3
    THIRD_PARTY_CODE("/lol/platform/v3/third-party-code/by-summoner/{summonerId}", String.class);

    private String pattern;
    private Class returnType;

    Endpoints(String pattern, Class returnType) {
        this.pattern = pattern;
        this.returnType = returnType;
    }
}
