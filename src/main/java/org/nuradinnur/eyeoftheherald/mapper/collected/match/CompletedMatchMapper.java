package org.nuradinnur.eyeoftheherald.mapper.collected.match;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.*;
import org.nuradinnur.eyeoftheherald.domain.collected.clean.match.*;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.match.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CompletedMatchMapper {

    public CompletedMatch map(MatchDTO dto) {
        val result = new CompletedMatch();
        result.setGameId(dto.getGameId());
        result.setSeason(Seasons.getByValue(dto.getSeasonId()));
        result.setPatch(dto.getGameVersion());
        result.setRegion(Regions.valueOf(dto.getPlatformId()));
        result.setMatchmaking(Matchmaking.valueOf(dto.getGameMode()));
        result.setQueue(Queues.getByValue(dto.getQueueId()));
        result.setMode(Modes.getByValue(dto.getGameMode()));
        result.setMap(Maps.getByValue(dto.getMapId()));
        val startTime = Instant.ofEpochMilli(dto.getGameCreation()).atZone(ZoneOffset.UTC);
        result.setStartTime(startTime);
        result.setDuration(dto.getGameDuration());
        val identities = dto.getParticipantIdentities().stream()
                .map(identity -> map(identity, result.getGameId()))
                .collect(Collectors.toList());
        result.setParticipantIdentities(identities);
        val participants = dto.getParticipants().stream()
                .map(participant -> map(participant, result.getGameId()))
                .collect(Collectors.toList());
        result.setParticipants(participants);
        val teamStats = dto.getTeams().stream()
                .map(stats -> map(stats, result.getGameId()))
                .collect(Collectors.toList());
        return result;
    }

    private ParticipantIdentity map(ParticipantIdentityDTO dto, Long gameId) {
        val result = new ParticipantIdentity();
        result.setGameId(gameId);
        result.setParticipantId(dto.getParticipantId());
        result.setCurrentRegion(Regions.valueOf(dto.getPlayer().getCurrentPlatformId()));
        result.setOriginalRegion(Regions.valueOf(dto.getPlayer().getPlatformId()));
        result.setCurrentAccountId(dto.getPlayer().getCurrentAccountId());
        result.setOriginalAccountId(dto.getPlayer().getAccountId());
        result.setSummonerId(dto.getPlayer().getSummonerId());
        result.setSummonerName(dto.getPlayer().getSummonerName());
        result.setSummonerIconId(dto.getPlayer().getProfileIcon());
        return result;
    }

    private Participant map(ParticipantDTO dto, Long gameId) {
        val result = new Participant();
        result.setGameId(gameId);
        result.setParticipantId(dto.getParticipantId());
        result.setIsOnBlueSide(dto.getTeamId() == 100);
        result.setHighestTierThisSeason(Tiers.valueOf(dto.getHighestAchievedSeasonTier()));
        result.setChampionId(dto.getChampionId());
        result.setSummonerSpellIds(Arrays.asList(dto.getSpell1Id(), dto.getSpell2Id()));
        result.setStats(map(dto.getStats(), gameId, result.getParticipantId()));
        result.setTimeline(map(dto.getTimeline(), gameId, result.getParticipantId()));
        return result;
    }

    private ParticipantStats map(ParticipantStatsDTO dto, Long gameId, Integer participantId) {
        val result = new ParticipantStats();
        result.setGameId(gameId);
        result.setParticipantId(participantId);
        result.setIsWin(dto.getWin());
        result.setChampionLevel(dto.getChampLevel());
        result.setKills(dto.getKills());
        result.setDeaths(dto.getDeaths());
        result.setAssists(dto.getAssists());
        result.setPrimaryRuneTree(dto.getPerkPrimaryStyle());
        result.setSecondaryRuneTree(dto.getPerkSubStyle());
        result.setRuneIds(Arrays.asList(dto.getPerk0(),
                dto.getPerk1(),
                dto.getPerk2(),
                dto.getPerk3(),
                dto.getPerk4(),
                dto.getPerk5()));
        result.setStatRuneIds(Arrays.asList(dto.getStatPerk0(),
                dto.getStatPerk1(),
                dto.getStatPerk2()));
        result.setRune1Performance(Arrays.asList(dto.getPerk1Var1(),
                dto.getPerk1Var2(),
                dto.getPerk1Var3()));
        result.setRune2Performance(Arrays.asList(dto.getPerk2Var1(),
                dto.getPerk2Var2(),
                dto.getPerk2Var3()));
        result.setRune3Performance(Arrays.asList(dto.getPerk3Var1(),
                dto.getPerk3Var2(),
                dto.getPerk3Var3()));
        result.setRune4Performance(Arrays.asList(dto.getPerk4Var1(),
                dto.getPerk4Var2(),
                dto.getPerk4Var3()));
        result.setRune5Performance(Arrays.asList(dto.getPerk5Var1(),
                dto.getPerk5Var2(),
                dto.getPerk5Var3()));
        result.setRune6Performance(Arrays.asList(dto.getPerk6Var1(),
                dto.getPerk6Var2(),
                dto.getPerk6Var3()));
        result.setItems(Arrays.asList(dto.getItem0(),
                dto.getItem1(),
                dto.getItem2(),
                dto.getItem3(),
                dto.getItem4(),
                dto.getItem5()));
        result.setTrinket(dto.getItem6());
        result.setGoldEarned(dto.getGoldEarned());
        result.setGoldSpent(dto.getGoldSpent());
        result.setDoubleKills(dto.getDoubleKills());
        result.setTripleKills(dto.getTripleKills());
        result.setQuadraKills(dto.getQuadraKills());
        result.setPentaKills(dto.getPentaKills());
        result.setLegendaryKills(dto.getUnrealKills());
        result.setLargestMultiKill(dto.getLargestMultiKill());
        result.setKillingSprees(dto.getKillingSprees());
        result.setHasFirstBloodAssist(dto.getFirstBloodAssist());
        result.setHasFirstBloodKill(dto.getFirstBloodKill());
        result.setHasFirstInhibitorAssist(dto.getFirstInhibitorAssist());
        result.setHasFirstInhibitorKill(dto.getFirstInhibitorKill());
        result.setHasFirstTowerAssist(dto.getFirstTowerAssist());
        result.setHasFirstTowerKill(dto.getFirstTowerKill());
        result.setTowerKills(dto.getTurretKills());
        result.setInhibitorKills(dto.getInhibitorKills());
        result.setDamageDealtToTowers(dto.getDamageDealtToTurret());
        result.setDamageDealtToObjectives(dto.getDamageDealtToObjectives());
        result.setLargestCriticalStrike(dto.getLargestCriticalStrike());
        result.setPhysicalDamageDealtToChampions(dto.getPhysicalDamageDealtToChampions());
        result.setPhysicalDamageDealt(dto.getPhysicalDamageDealt());
        result.setPhysicalDamageTaken(dto.getPhysicalDamageTaken());
        result.setMagicDamageDealtToChampions(dto.getMagicDamageDealtToChampions());
        result.setMagicDamageDealt(dto.getMagicDamageDealt());
        result.setMagicDamageTaken(dto.getMagicalDamageTaken());
        result.setTrueDamageDealtToChampions(dto.getTrueDamageDealtToChampions());
        result.setTrueDamageDealt(dto.getTrueDamageDealt());
        result.setTrueDamageTaken(dto.getTrueDamageTaken());
        result.setTotalDamageDealtToChampions(dto.getTotalDamageDealtToChampions());
        result.setTotalDamageDealt(dto.getTotalDamageDealt());
        result.setTotalDamageTaken(dto.getTotalDamageTaken());
        result.setDamageSelfMitigated(dto.getDamageSelfMitigated());
        result.setLongestTimeSpentLiving(dto.getLongestTimeSpentLiving());
        result.setTotalTimeCrowdControlDealt(dto.getTotalTimeCrowdControlDealt());
        result.setCrowdControlEffectivenessScore(dto.getTimeCCingOthers());
        result.setTotalHealthHealed(dto.getTotalHeal());
        result.setTotalUnitsHealed(dto.getTotalUnitsHealed());
        result.setTotalMinionsKilled(dto.getTotalMinionsKilled());
        result.setNeutralMinionsKilled(dto.getNeutralMinionsKilled());
        result.setNeutralMinionsKilledEnemyJungle(dto.getNeutralMinionsKilledEnemyJungle());
        result.setNeutralMinionsKilledTeamJungle(dto.getNeutralMinionsKilledTeamJungle());
        result.setVisionScore(dto.getVisionScore());
        result.setWardsPlaced(dto.getWardsPlaced());
        result.setWardsKilled(dto.getWardsKilled());
        result.setStealthWardsBought(dto.getSightWardsBoughtInGame());
        result.setControlWardsBought(dto.getVisionWardsBoughtInGame());
        result.setPlayerScores(Arrays.asList(dto.getPlayerScore0(),
                dto.getPlayerScore1(),
                dto.getPlayerScore2(),
                dto.getPlayerScore3(),
                dto.getPlayerScore4(),
                dto.getPlayerScore5(),
                dto.getPlayerScore6(),
                dto.getPlayerScore7(),
                dto.getPlayerScore8(),
                dto.getPlayerScore9()));
        result.setCombatPlayerScore(dto.getCombatPlayerScore());
        result.setObjectivePlayerScore(dto.getObjectivePlayerScore());
        result.setTotalPlayerScore(dto.getTotalPlayerScore());
        result.setTotalScoreRank(dto.getTotalScoreRank());
        result.setTeamObjective(dto.getTeamObjective());
        result.setNodeNeutralizationAssists(dto.getNodeNeutralizeAssist());
        result.setNodesNeutralized(dto.getNodeNeutralize());
        result.setNodeCaptureAssists(dto.getNodeCaptureAssist());
        result.setNodesCaptured(dto.getNodeCapture());
        result.setAltarsNeutralized(dto.getAltarsNeutralized());
        result.setAltarsCaptured(dto.getAltarsCaptured());
        return result;
    }

    private ParticipantTimeline map(ParticipantTimelineDTO dto, Long gameId, Integer participantId) {
        val result = new ParticipantTimeline();
        result.setGameId(gameId);
        result.setParticipantId(participantId);
        result.setLane(Lanes.valueOf(dto.getLane()));
        result.setRole(Roles.valueOf(dto.getRole()));
        result.setGoldPerMinute(mapTimeline(dto.getGoldPerMinDeltas()));
        result.setCreepScorePerMinute(mapTimeline(dto.getCreepsPerMinDeltas()));
        result.setCreepScoreDifferentials(mapTimeline(dto.getCsDiffPerMinDeltas()));
        result.setExperiencePerMinute(mapTimeline(dto.getXpPerMinDeltas()));
        result.setExperienceDifferentials(mapTimeline(dto.getXpDiffPerMinDeltas()));
        result.setDamageTakenPerMinute(mapTimeline(dto.getDamageTakenPerMinDeltas()));
        result.setDamageTakenDifferentials(mapTimeline(dto.getDamageTakenDiffPerMinDeltas()));
        return result;
    }

    private List<Double> mapTimeline(Map<String, Double> timeline) {
        return Arrays.asList(timeline.get("0-10"),
                timeline.get("10-20"),
                timeline.get("20-30"),
                timeline.get("30-end"));
    }

    private TeamStats map(TeamStatsDTO dto, Long gameId) {
        val result = new TeamStats();
        result.setGameId(gameId);
        result.setIsBlueTeam(dto.getTeamId() == 100);
        result.setIsWin(dto.getWin().equalsIgnoreCase("WIN"));
        result.setFirstBlood(dto.getFirstBlood());
        result.setFirstTower(dto.getFirstTower());
        result.setFirstInhibitor(dto.getFirstInhibitor());
        result.setFirstDragon(dto.getFirstDragon());
        result.setFirstRiftHerald(dto.getFirstRiftHerald());
        result.setFirstBaron(dto.getFirstBaron());
        result.setTowerKills(dto.getTowerKills());
        result.setInhibitorKills(dto.getInhibitorKills());
        result.setDragonKills(dto.getDragonKills());
        result.setRiftHeraldKills(dto.getRiftHeraldKills());
        result.setBaronKills(dto.getBaronKills());
        result.setVilemawKills(dto.getVilemawKills());
        result.setDominionVictoryScore(dto.getDominionVictoryScore());
        val bans = dto.getBans().stream()
                .map(ban -> map(ban, result.getGameId()))
                .collect(Collectors.toList());
        result.setBans(bans);
        return result;
    }

    private TeamBans map(TeamBansDTO dto, Long gameId) {
        val result = new TeamBans();
        result.setGameId(gameId);
        result.setPickTurn(dto.getPickTurn());
        result.setChampionId(dto.getChampionId());
        return result;
    }
}
