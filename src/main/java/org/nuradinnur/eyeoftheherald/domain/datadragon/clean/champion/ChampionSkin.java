package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ChampionSkin {
    @Id
    Integer id;
    String name;
    Boolean hasChromas;
}
