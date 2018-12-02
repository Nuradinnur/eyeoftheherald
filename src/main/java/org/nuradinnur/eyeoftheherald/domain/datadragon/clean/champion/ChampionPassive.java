package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameImage;

import javax.persistence.*;

@Data
@Entity
public class ChampionPassive {
    @Id
    @Column(length = 100)
    String name;
    String description;
    @OneToOne(cascade = CascadeType.ALL)
    GameImage image;
}
