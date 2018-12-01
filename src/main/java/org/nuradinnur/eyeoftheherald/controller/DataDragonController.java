package org.nuradinnur.eyeoftheherald.controller;

import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion.Champion;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.item.Item;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.rune.RuneTree;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.icon.ProfileIconsDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell.SummonerSpellsDTO;
import org.nuradinnur.eyeoftheherald.service.datadragon.DataDragonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/{locale}/static/data")
public class DataDragonController {

    private final DataDragonService dataDragonService;

    public DataDragonController(DataDragonService dataDragonService) {
        this.dataDragonService = dataDragonService;
    }

    @GetMapping("/champions")
    public List<Champion> getChampions(@PathVariable("locale") Locales locale) {
        return dataDragonService.getChampions(locale);
    }

    @GetMapping("/items")
    public List<Item> getItems(@PathVariable("locale") Locales locale) {
        return dataDragonService.getItems(locale);
    }

    @GetMapping("/runes")
    public List<RuneTree> getRuneTrees(@PathVariable("locale") Locales locale) {
        return dataDragonService.getRuneTrees(locale);
    }

    @GetMapping("/summoner-icons")
    public ProfileIconsDTO getSummonerIcons(@PathVariable("locale") Locales locale) {
        return dataDragonService.getSummonerIcons(locale);
    }

    @GetMapping("/summoner-spells")
    public SummonerSpellsDTO summonerSpells(@PathVariable("locale") Locales locale) {
        return dataDragonService.getSummonerSpells(locale);
    }
}
