package org.nuradinnur.eyeoftheherald.service.datadragon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.DataDragonFiles;
import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion.Champion;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.item.Item;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion.ChampionDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.icon.ProfileIconsDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.item.ItemDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune.RunePathDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune.RunesDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell.SummonerSpellsDTO;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.champion.ChampionMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.item.ItemMapper;
import org.nuradinnur.eyeoftheherald.service.GameVersioningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataDragonService {

    private final Logger logger;

    private final GameVersioningService gameVersioningService;
    private final ObjectMapper objectMapper;
    private final ChampionMapper championMapper;
    private final ItemMapper itemMapper;

    private Map<Locales, List<Champion>> champions;
    private Map<Locales, List<Item>> items;
    private Map<Locales, RunesDTO> runes;
    private Map<Locales, ProfileIconsDTO> summonerIcons;
    private Map<Locales, SummonerSpellsDTO> summonerSpells;

    public DataDragonService(ObjectMapper objectMapper, GameVersioningService gameVersioningService, ChampionMapper championMapper, ItemMapper itemMapper) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.gameVersioningService = gameVersioningService;
        this.objectMapper = objectMapper;
        this.championMapper = championMapper;
        this.itemMapper = itemMapper;
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

    public List<Champion> getChampions(Locales locale) {
        return champions.get(locale);
    }

    public List<Item> getItems(Locales locale) {
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
            }
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }

    private synchronized void populateData(Locales locale) throws IOException {
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

        val championData = getChampionData(locale);
        val itemData = getItemData(locale);

        champions.put(locale, championData);
        items.put(locale, itemData);
        runes.put(locale, runesDto);
        summonerSpells.put(locale, summonerSpellsDto);
        summonerIcons.put(locale, summonerIconsDto);

        logger.info("Loaded data dragon files for {} ({})", locale.name(), locale.getIdentifier());
    }

    private List<Champion> getChampionData(Locales locale) throws IOException {
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.CHAMPIONS).toFile();
        val data = objectMapper.readTree(file).path("data");
        val classType = objectMapper.getTypeFactory().constructType(ChampionDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        val result = new ArrayList<ChampionDTO>();
        for (val node : data) {
            result.add(typedObjectReader.readValue(node));
        }
        return championMapper.mapAll(result);
    }

    private List<Item> getItemData(Locales locale) throws IOException {
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.ITEMS).toFile();
        val data = objectMapper.readTree(file).path("data");
        val classType = objectMapper.getTypeFactory().constructType(ItemDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        val result = new ArrayList<ItemDTO>();
        val itemIdIterator = data.fieldNames();
        while (itemIdIterator.hasNext()) {
            val fieldName = itemIdIterator.next();
            val node = data.get(fieldName);
            val item = typedObjectReader.readValue(node);
            ((ItemDTO) item).setId(Long.parseLong(fieldName));
            result.add((ItemDTO) item);
            itemIdIterator.remove();
        }
        return itemMapper.mapAll(result);
    }

    private <T> T getDataAsObject(Locales locale, DataDragonFiles dataDragonFile, Class<T> type) throws IOException {
        val dataDragonFilePath = gameVersioningService.getDataDragonDefinitionPath(locale, dataDragonFile).toFile();
        return objectMapper.readValue(dataDragonFilePath, type);
    }

    private <T> List<T> getDataAsList(Locales locale, DataDragonFiles dataDragonFile, Class<T> type) throws IOException {
        val dataDragonFilePath = gameVersioningService.getDataDragonDefinitionPath(locale, dataDragonFile).toFile();
        return objectMapper.readValue(dataDragonFilePath, new TypeReference<List<T>>() {});
    }
}
