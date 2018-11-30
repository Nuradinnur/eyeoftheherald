package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;

import javax.persistence.*;

@Data
@Entity
public class ChampionPassive {
    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    @OneToOne(cascade = CascadeType.ALL)
    GameSprite sprite;
}
