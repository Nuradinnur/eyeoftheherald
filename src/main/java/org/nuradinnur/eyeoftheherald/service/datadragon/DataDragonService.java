package org.nuradinnur.eyeoftheherald.service.datadragon;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.DataDragonFiles;
import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion.Champion;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.item.Item;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.rune.RuneTree;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell.SummonerSpell;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion.ChampionDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.icon.ProfileIconsDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.item.ItemDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune.RuneTreeDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell.SummonerSpellDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell.SummonerSpellsDTO;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.champion.ChampionMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.item.ItemMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.runetree.RuneTreeMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.summonerspell.SummonerSpellMapper;
import org.nuradinnur.eyeoftheherald.service.GameVersioningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Service
public class DataDragonService {

    private final Logger logger;

    private final GameVersioningService gameVersioningService;
    private final ObjectMapper objectMapper;
    private final ChampionMapper championMapper;
    private final ItemMapper itemMapper;
    private final RuneTreeMapper runeTreeMapper;
    private final SummonerSpellMapper summonerSpellMapper;

    private Map<Locales, List<Champion>> champions;
    private Map<Locales, List<Item>> items;
    private Map<Locales, List<RuneTree>> runeTrees;
    private Map<Locales, ProfileIconsDTO> summonerIcons;
    private Map<Locales, List<SummonerSpell>> summonerSpells;

    public DataDragonService(ObjectMapper objectMapper, GameVersioningService gameVersioningService, ChampionMapper championMapper, ItemMapper itemMapper, RuneTreeMapper runeTreeMapper, SummonerSpellMapper summonerSpellMapper) {
        this.summonerSpellMapper = summonerSpellMapper;
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.gameVersioningService = gameVersioningService;
        this.objectMapper = objectMapper;
        this.championMapper = championMapper;
        this.itemMapper = itemMapper;
        this.runeTreeMapper = runeTreeMapper;
        this.champions = new HashMap<>();
        this.items = new HashMap<>();
        this.runeTrees = new HashMap<>();
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

    public List<RuneTree> getRuneTrees(Locales locale) {
        return runeTrees.get(locale);
    }

    public ProfileIconsDTO getSummonerIcons(Locales locale) {
        return summonerIcons.get(locale);
    }

    public List<SummonerSpell> getSummonerSpells(Locales locale) {
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
        val summonerSpellsDto = getDataAsObject(locale,
                DataDragonFiles.SUMMONER_SPELLS,
                SummonerSpellsDTO.class);
        val summonerIconsDto = getDataAsObject(locale,
                DataDragonFiles.SUMMONER_ICONS,
                ProfileIconsDTO.class);

        val championData = getChampionData(locale);
        val itemData = getItemData(locale);
        val runesData = getRuneTreeData(locale);
        val summonerSpellData = getSummonerSpellData(locale);

        champions.put(locale, championData);
        items.put(locale, itemData);
        runeTrees.put(locale, runesData);
        summonerSpells.put(locale, summonerSpellData);
        summonerIcons.put(locale, summonerIconsDto);

        logger.info("Loaded data dragon files for {} ({})", locale.name(), locale.getIdentifier());
    }

    private List<Champion> getChampionData(Locales locale) throws IOException {
        val result = new ArrayList<ChampionDTO>();
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.CHAMPIONS).toFile();
        val data = objectMapper.readTree(file).path("data");
        val classType = objectMapper.getTypeFactory().constructType(ChampionDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        for (val node : data) {
            result.add(typedObjectReader.readValue(node));
        }
        return championMapper.mapAll(result);
    }

    private List<Item> getItemData(Locales locale) throws IOException {
        val result = new ArrayList<ItemDTO>();
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.ITEMS).toFile();
        val data = objectMapper.readTree(file).path("data");
        val classType = objectMapper.getTypeFactory().constructType(ItemDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
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

    private List<RuneTree> getRuneTreeData(Locales locale) throws IOException {
        val result = new ArrayList<RuneTreeDTO>();
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.RUNES).toFile();
        val data = objectMapper.readTree(file);
        val classType = objectMapper.getTypeFactory().constructType(RuneTreeDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        for (val node : data) {
            result.add(typedObjectReader.readValue(node));
        }
        return runeTreeMapper.mapAll(result);
    }

    private List<SummonerSpell> getSummonerSpellData(Locales locale) throws IOException {
        val result = new ArrayList<SummonerSpellDTO>();
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.SUMMONER_SPELLS).toFile();
        val data = objectMapper.readTree(file).path("data");
        val classType = objectMapper.getTypeFactory().constructType(SummonerSpellDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        for (val node : data) {
            result.add(typedObjectReader.readValue(node));
        }
        result.sort(Comparator.comparingInt(SummonerSpellDTO::getKey));
        return summonerSpellMapper.mapAll(result);
    }


    private <T> T getDataAsObject(Locales locale, DataDragonFiles dataDragonFile, Class<T> type) throws IOException {
        val dataDragonFilePath = gameVersioningService.getDataDragonDefinitionPath(locale, dataDragonFile).toFile();
        return objectMapper.readValue(dataDragonFilePath, type);
    }
}
