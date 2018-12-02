package org.nuradinnur.eyeoftheherald.mapper.datadragon.icon;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.icon.SummonerIcon;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.icon.SummonerIconDTO;
import org.nuradinnur.eyeoftheherald.mapper.datadragon.GameImageMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SummonerIconMapper {

    private final GameImageMapper gameImageMapper;

    public SummonerIconMapper(GameImageMapper gameImageMapper) {
        this.gameImageMapper = gameImageMapper;
    }

    public List<SummonerIcon> mapAll(List<SummonerIconDTO> dtos) {
        return dtos.stream().map(this::map).collect(Collectors.toList());
    }

    public SummonerIcon map(SummonerIconDTO dto) {
        val result = new SummonerIcon();
        result.setId(dto.getId());
        result.setImage(gameImageMapper.map(dto.getImage()));
        return result;
    }
}
