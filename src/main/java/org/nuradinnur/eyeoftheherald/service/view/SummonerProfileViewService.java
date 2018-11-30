package org.nuradinnur.eyeoftheherald.service.view;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.nuradinnur.eyeoftheherald.constant.Regions;
import org.nuradinnur.eyeoftheherald.domain.collected.dto.match.MatchDTO;
import org.nuradinnur.eyeoftheherald.service.collection.DataCollectionService;
import org.nuradinnur.eyeoftheherald.service.datadragon.DataDragonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SummonerProfileViewService {

    private final DataDragonService dataDragonService;
    private final DataCollectionService dataCollectionService;

    public SummonerProfileViewService(DataDragonService dataDragonService, DataCollectionService dataCollectionService) {
        this.dataDragonService = dataDragonService;
        this.dataCollectionService = dataCollectionService;
    }

    public Object getView(Locales locale, Regions region, String summonerName) {
        val summonerData = dataCollectionService.getSummonerByName(region, summonerName);
        val leaguePosition = dataCollectionService.getLeaguePosition(region, summonerData.getId().toString());
        val matchList = dataCollectionService.getPaginatedMatchList(region, summonerData.getAccountId().toString(), 0);
        val matches = new ArrayList<MatchDTO>();
        for (val reference : matchList.getMatches()) {
            dataCollectionService.getMatch(region, reference.getGameId().toString());
        }
        return null;
    }
}
