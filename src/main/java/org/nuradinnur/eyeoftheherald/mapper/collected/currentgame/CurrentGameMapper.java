package org.nuradinnur.eyeoftheherald.mapper.collected.currentgame;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.*;
import org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame.BannedChampion;
import org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame.CurrentGame;
import org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame.CurrentGameParticipant;
import org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame.GameCustomization;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame.BannedChampionDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame.CurrentGameInfoDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame.CurrentGameParticipantDTO;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.currentgame.GameCustomizationObjectDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class CurrentGameMapper {

    CurrentGame map(CurrentGameInfoDTO dto) {
        val result = new CurrentGame();
        result.setGameId(dto.getGameId());
        result.setRegion(Regions.valueOf(dto.getPlatformId()));
        result.setMatchmaking(Matchmaking.valueOf(dto.getGameMode()));
        result.setMode(Modes.getByValue(dto.getGameMode()));
        result.setMap(Maps.getByValue(dto.getMapId().intValue()));
        result.setQueue(Queues.getByValue(dto.getGameQueueConfigId().intValue()));
        result.setGameStartTime(Instant.ofEpochMilli(dto.getGameStartTime()).atZone(ZoneOffset.UTC));
        result.setGameLength(dto.getGameLength());
        result.setObserverEncryptionKey(dto.getObservers().getEncryptionKey());
        val participants = dto.getParticipants().stream()
                .map(participant -> map(participant, result.getGameId()))
                .collect(Collectors.toList());
        result.setParticipants(participants);
        val bannedChampions = dto.getBannedChampions().stream()
                .map(champion -> map(champion, result.getGameId()))
                .collect(Collectors.toList());
        result.setBannedChampions(bannedChampions);
        return result;
    }

    private CurrentGameParticipant map(CurrentGameParticipantDTO dto, Long gameId) {
        val result = new CurrentGameParticipant();
        result.setGameId(gameId);
        result.setSummonerId(dto.getSummonerId());
        result.setSummonerName(dto.getSummonerName());
        result.setSummonerIconId(dto.getProfileIconId().intValue());
        result.setChampionId(dto.getChampionId().intValue());
        result.setSummonerSpells(Arrays.asList(dto.getSpell1Id().intValue(),
                dto.getSpell2Id().intValue()));
        result.setRunes(dto.getPerks().getPerkIds().stream().map(Long::intValue).collect(Collectors.toList()));
        result.setPrimaryRuneTree(dto.getPerks().getPerkStyle().intValue());
        result.setSecondaryRuneTree(dto.getPerks().getPerkSubStyle().intValue());
        result.setIsOnBlueSide(dto.getTeamId() == 100);
        result.setIsBot(dto.getBot());
        val gameCustomizations = dto.getGameCustomizationObjects().stream()
                .map(customization -> map(customization, result.getGameId(), result.getSummonerId()))
                .collect(Collectors.toList());
        result.setGameCustomizations(gameCustomizations);
        return result;
    }

    private GameCustomization map(GameCustomizationObjectDTO dto, Long gameId, Long summonerId) {
        val result = new GameCustomization();
        result.setGameId(gameId);
        result.setSummonerId(summonerId);
        result.setCategory(dto.getCategory());
        result.setContent(dto.getContent());
        return result;
    }

    private BannedChampion map(BannedChampionDTO dto, Long gameId) {
        val result = new BannedChampion();
        result.setGameId(gameId);
        result.setPickTurn(dto.getPickTurn());
        result.setChampionId(dto.getChampionId().intValue());
        result.setIsOnBlueSide(dto.getTeamId() == 100);
        return result;
    }
}
