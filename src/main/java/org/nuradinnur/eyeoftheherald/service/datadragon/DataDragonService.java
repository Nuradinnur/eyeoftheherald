package org.nuradinnur.eyeoftheherald.service.datadragon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.DataDragonFiles;
import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion.ChampionsDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.icon.ProfileIconsDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.item.ItemsDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune.RunePathDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune.RunesDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell.SummonerSpellsDTO;
import org.nuradinnur.eyeoftheherald.mapper.ChampionMapper;
import org.nuradinnur.eyeoftheherald.service.GameVersioningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataDragonService {

    private final Logger logger;

    private final ObjectMapper objectMapper;
    private final GameVersioningService gameVersioningService;

    private ChampionMapper championMapper;

    private Map<Locales, ChampionsDTO> champions;
    private Map<Locales, ItemsDTO> items;
    private Map<Locales, RunesDTO> runes;
    private Map<Locales, ProfileIconsDTO> summonerIcons;
    private Map<Locales, SummonerSpellsDTO> summonerSpells;

    public DataDragonService(ChampionMapper championMapper, ObjectMapper objectMapper, GameVersioningService gameVersioningService) {
        this.championMapper = championMapper;
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.objectMapper = objectMapper;
        this.gameVersioningService = gameVersioningService;
        this.champions = new HashMap<>();
        this.items = new HashMap<>();
        this.runes = new HashMap<>();
        this.summonerIcons = new HashMap<>();
        this.summonerSpells = new HashMap<>();
    }

    @PostConstruct
    private void initialize() {
        checkForUpdates();
    }

    public ChampionsDTO getChampions(Locales locale) {
        return champions.get(locale);
    }

    public ItemsDTO getItems(Locales locale) {
        return items.get(locale);
    }

    public RunesDTO getRunes(Locales locale) {
        return runes.get(locale);
    }

    public ProfileIconsDTO getSummonerIcons(Locales locale) {
        return summonerIcons.get(locale);
    }

    public SummonerSpellsDTO getSummonerSpells(Locales locale) {
        return summonerSpells.get(locale);
    }

    @Scheduled(fixedDelay = 60 * 60 * 1000, initialDelay = 90 * 60 * 1000)
    private void checkForUpdates() {
        try {
            for (val locale : Locales.values()) {
                populateData(locale);
                logger.info("Loaded data dragon files for locale {}", locale.getIdentifier());
            }
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }

    private synchronized void populateData(Locales locale) throws IOException {
        val championsDto = getDataAsObject(locale,
                DataDragonFiles.CHAMPIONS,
                ChampionsDTO.class);
        val itemsDto = getDataAsObject(locale,
                DataDragonFiles.ITEMS,
                ItemsDTO.class);
        val runePathsDto = getDataAsList(locale,
                DataDragonFiles.RUNES,
                RunePathDTO.class);
        val runesDto = new RunesDTO();
        runesDto.setPaths(runePathsDto);
        val summonerSpellsDto = getDataAsObject(locale,
                DataDragonFiles.SUMMONER_SPELLS,
                SummonerSpellsDTO.class);
        val summonerIconsDto = getDataAsObject(locale,
                DataDragonFiles.SUMMONER_ICONS,
                ProfileIconsDTO.class);

        champions.clear();
        items.clear();
        runes.clear();
        summonerSpells.clear();
        summonerIcons.clear();

        champions.put(locale, championsDto);
        items.put(locale, itemsDto);
        runes.put(locale, runesDto);
        summonerSpells.put(locale, summonerSpellsDto);
        summonerIcons.put(locale, summonerIconsDto);
    }

    private <T> T getDataAsObject(Locales locale, DataDragonFiles dataDragonFile, Class<T> type) throws IOException {
        val jsonFilePath = gameVersioningService.getDataDragonDefinitionPath(locale, dataDragonFile).toFile();
        return objectMapper.readValue(jsonFilePath, type);
    }

    private <T> List<T> getDataAsList(Locales locale, DataDragonFiles dataDragonFile, Class<T> type) throws IOException {
        val jsonFilePath = gameVersioningService.getDataDragonDefinitionPath(locale, dataDragonFile).toFile();
        return objectMapper.readValue(jsonFilePath, new TypeReference<List<T>>() {
        });
    }
}
