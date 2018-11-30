package org.nuradinnur.eyeoftheherald.controller;

import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.champion.ChampionsDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.icon.ProfileIconsDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.item.ItemsDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune.RunesDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.spell.SummonerSpellsDTO;
import org.nuradinnur.eyeoftheherald.service.datadragon.DataDragonService;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping(value = "/static/data")
public class DataDragonController {

    private final DataDragonService dataDragonService;

    public DataDragonController(DataDragonService dataDragonService) {
        this.dataDragonService = dataDragonService;
    }

    @GetMapping("/{locale}/champions")
    public ChampionsDTO getChampions(@PathVariable("locale") Locales locale) {
        return dataDragonService.getChampions(locale);
    }

    @GetMapping("/{locale}/items")
    public ItemsDTO getItems(@PathVariable("locale") Locales locale) {
        return dataDragonService.getItems(locale);
    }

    @GetMapping("/{locale}/runes")
    public RunesDTO getRunes(@PathVariable("locale") Locales locale) {
        return dataDragonService.getRunes(locale);
    }

    @GetMapping("/{locale}/summoner-icons")
    public ProfileIconsDTO getSummonerIcons(@PathVariable("locale") Locales locale) {
        return dataDragonService.getSummonerIcons(locale);
    }

    @GetMapping("/{locale}/summoner-spells")
    public SummonerSpellsDTO summonerSpells(@PathVariable("locale") Locales locale) {
        return dataDragonService.getSummonerSpells(locale);
    }
}
