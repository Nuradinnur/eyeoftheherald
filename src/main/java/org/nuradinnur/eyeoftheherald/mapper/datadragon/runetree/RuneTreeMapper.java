package org.nuradinnur.eyeoftheherald.mapper.datadragon.runetree;

import lombok.val;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.rune.Rune;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.rune.RuneTree;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune.RuneDTO;
import org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune.RuneTreeDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RuneTreeMapper {

    public List<RuneTree> mapAll(List<RuneTreeDTO> dtos) {
        return dtos.stream().map(this::map).collect(Collectors.toList());
    }

    public RuneTree map(RuneTreeDTO dto) {
        val result = new RuneTree();
        result.setId(dto.getId());
        result.setName(dto.getName());
        result.setKeystones(dto.getSlots().get(0).getRunes().stream()
                .map(this::map).collect(Collectors.toList()));
        result.setTier1(dto.getSlots().get(1).getRunes().stream()
                .map(this::map).collect(Collectors.toList()));
        result.setTier2(dto.getSlots().get(2).getRunes().stream()
                .map(this::map).collect(Collectors.toList()));
        result.setTier3(dto.getSlots().get(3).getRunes().stream()
                .map(this::map).collect(Collectors.toList()));
        return result;
    }

    private Rune map(RuneDTO dto) {
        val result = new Rune();
        result.setId(dto.getId());
        result.setName(dto.getName());
        result.setSpriteFileName(dto.getKey() + ".png");
        result.setSummary(dto.getShortDesc());
        result.setDescription(dto.getLongDesc());
        return result;
    }
}
