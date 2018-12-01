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
    Integer id;
    String name;
    Integer skinIndex;
    Boolean hasChromas;
}
