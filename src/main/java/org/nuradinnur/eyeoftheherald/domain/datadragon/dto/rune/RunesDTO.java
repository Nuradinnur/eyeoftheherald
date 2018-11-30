package org.nuradinnur.eyeoftheherald.domain.datadragon.dto.rune;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.util.List;

@Data
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class RunesDTO {
    private List<RunePathDTO> paths;
}
