package org.nuradinnur.eyeoftheherald.mapper;

import org.nuradinnur.eyeoftheherald.constant.Maps;
import org.springframework.stereotype.Component;

@Component
public class MapsMapper {

    public Maps map(String dto) {
        switch(dto.toUpperCase()) {
            case "SR":
                return Maps.SUMMONERS_RIFT_CURRENT;
            case "HA":
                return Maps.HOWLING_ABYSS;
            case "TT":
                return Maps.TWISTED_TREELINE_CURRENT;
            case "CRYSTALSCAR":
                return Maps.THE_CRYSTAL_SCAR;
            case "CITYPARK":
                return Maps.VALORAN_CITY_PARK;
            case "PROJECTSLUMS":
                return Maps.SUBSTRUCTURE_43;
            case "SL":
                return Maps.NEXUS_BLITZ;
            default:
                return Maps.UNKNOWN;
        }
    }
}
