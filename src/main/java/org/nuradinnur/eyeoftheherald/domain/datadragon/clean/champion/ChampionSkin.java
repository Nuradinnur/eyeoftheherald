package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ChampionSkin {
    @Id
    @JsonIgnore
    private Integer id;
    private String name;
    private Integer skinIndex;
    private Boolean hasChromas;
    private String imageFileName;
}
