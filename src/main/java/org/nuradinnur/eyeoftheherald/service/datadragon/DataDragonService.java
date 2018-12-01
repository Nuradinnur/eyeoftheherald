package org.nuradinnur.eyeoftheherald.service.datadragon;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.DataDragonFiles;
import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion.Champion;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.icon.SummonerIcon;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.item.Item;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.rune.RuneTree;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell.SummonerSpell;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion.ChampionDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.icon.SummonerIconDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.item.ItemDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune.RuneTreeDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell.SummonerSpellDTO;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.champion.ChampionMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.icon.SummonerIconMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.item.ItemMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.rune.RuneTreeMapper;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.spell.SummonerSpellMapper;
import org.nuradinnur.eyeoftheherald.service.GameVersioningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class DataDragonService {

    private final Logger logger;

    private final GameVersioningService gameVersioningService;
    private final ObjectMapper objectMapper;
    private final ChampionMapper championMapper;
    private final ItemMapper itemMapper;
    private final RuneTreeMapper runeTreeMapper;
    private final SummonerSpellMapper summonerSpellMapper;
    private final SummonerIconMapper summonerIconMapper;

    private Map<Locales, Map<Integer, Champion>> champions;
    private Map<Locales, Map<Integer, Item>> items;
    private Map<Locales, Map<Integer, RuneTree>> runeTrees;
    private Map<Locales, Map<Integer, SummonerIcon>> summonerIcons;
    private Map<Locales, Map<Integer, SummonerSpell>> summonerSpells;

    public DataDragonService(ObjectMapper objectMapper, GameVersioningService gameVersioningService, ChampionMapper championMapper, ItemMapper itemMapper, RuneTreeMapper runeTreeMapper, SummonerSpellMapper summonerSpellMapper, SummonerIconMapper summonerIconMapper) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.gameVersioningService = gameVersioningService;
        this.objectMapper = objectMapper;
        this.championMapper = championMapper;
        this.itemMapper = itemMapper;
        this.runeTreeMapper = runeTreeMapper;
        this.summonerIconMapper = summonerIconMapper;
        this.summonerSpellMapper = summonerSpellMapper;
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

    public Map<Integer, Champion> getChampions(Locales locale) {
        return champions.get(locale);
    }

    public Map<Integer, Item> getItems(Locales locale) {
        return items.get(locale);
    }

    public Map<Integer, RuneTree> getRuneTrees(Locales locale) {
        return runeTrees.get(locale);
    }

    public Map<Integer, SummonerIcon> getSummonerIcons(Locales locale) {
        return summonerIcons.get(locale);
    }

    public Map<Integer, SummonerSpell> getSummonerSpells(Locales locale) {
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
        val championData = getChampionData(locale);
        val itemData = getItemData(locale);
        val runesData = getRuneTreeData(locale);
        val summonerSpellData = getSummonerSpellData(locale);
        val summonerIconData = getSummonerIconData(locale);

        champions.put(locale, championData);
        items.put(locale, itemData);
        runeTrees.put(locale, runesData);
        summonerSpells.put(locale, summonerSpellData);
        summonerIcons.put(locale, summonerIconData);

        logger.info("Loaded data dragon files for {} ({})", locale.name(), locale.getIdentifier());
    }

    private Map<Integer, Champion> getChampionData(Locales locale) throws IOException {
        val result = new HashMap<Integer, Champion>();
        val dtos = new ArrayList<ChampionDTO>();
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.CHAMPIONS).toFile();
        val data = objectMapper.readTree(file).path("data");
        val classType = objectMapper.getTypeFactory().constructType(ChampionDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        for (val node : data) {
            dtos.add(typedObjectReader.readValue(node));
        }
        val champions = championMapper.mapAll(dtos);
        for (val champion : champions) {
            result.put(champion.getId(), champion);
        }
        return result;
    }

    private Map<Integer, Item> getItemData(Locales locale) throws IOException {
        val result = new HashMap<Integer, Item>();
        val dtos = new ArrayList<ItemDTO>();
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.ITEMS).toFile();
        val data = objectMapper.readTree(file).path("data");
        val classType = objectMapper.getTypeFactory().constructType(ItemDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        val itemIdIterator = data.fieldNames();
        while (itemIdIterator.hasNext()) {
            val fieldName = itemIdIterator.next();
            val node = data.get(fieldName);
            val item = typedObjectReader.readValue(node);
            ((ItemDTO) item).setId(Integer.parseInt(fieldName));
            dtos.add((ItemDTO) item);
            itemIdIterator.remove();
        }
        val items = itemMapper.mapAll(dtos);
        for (val item : items) {
            result.put(item.getId(), item);
        }
        return result;
    }

    private Map<Integer, RuneTree> getRuneTreeData(Locales locale) throws IOException {
        val result = new HashMap<Integer, RuneTree>();
        val dtos = new ArrayList<RuneTreeDTO>();
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.RUNES).toFile();
        val data = objectMapper.readTree(file);
        val classType = objectMapper.getTypeFactory().constructType(RuneTreeDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        for (val node : data) {
            dtos.add(typedObjectReader.readValue(node));
        }
        val runeTrees = runeTreeMapper.mapAll(dtos);
        for (val runeTree : runeTrees) {
            result.put(runeTree.getId(), runeTree);
        }
        return result;
    }

    private Map<Integer, SummonerSpell> getSummonerSpellData(Locales locale) throws IOException {
        val result = new HashMap<Integer, SummonerSpell>();
        val dtos = new ArrayList<SummonerSpellDTO>();
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.SUMMONER_SPELLS).toFile();
        val data = objectMapper.readTree(file).path("data");
        val classType = objectMapper.getTypeFactory().constructType(SummonerSpellDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        for (val node : data) {
            dtos.add(typedObjectReader.readValue(node));
        }
        val summonerSpells = summonerSpellMapper.mapAll(dtos);
        for (val summonerSpell : summonerSpells) {
            result.put(summonerSpell.getSpellId(), summonerSpell);
        }
        return result;
    }

    private Map<Integer, SummonerIcon> getSummonerIconData(Locales locale) throws IOException {
        val result = new HashMap<Integer, SummonerIcon>();
        val dtos = new ArrayList<SummonerIconDTO>();
        val file = gameVersioningService.getDataDragonDefinitionPath(locale, DataDragonFiles.SUMMONER_ICONS).toFile();
        val data = objectMapper.readTree(file).path("data");
        val classType = objectMapper.getTypeFactory().constructType(SummonerIconDTO.class);
        val typedObjectReader = objectMapper.readerFor(classType);
        for (val node : data) {
            dtos.add(typedObjectReader.readValue(node));
        }
        val summonerIcons = summonerIconMapper.mapAll(dtos);
        for (val summonerIcon : summonerIcons) {
            result.put(summonerIcon.getId(), summonerIcon);
        }
        return result;
    }
}
