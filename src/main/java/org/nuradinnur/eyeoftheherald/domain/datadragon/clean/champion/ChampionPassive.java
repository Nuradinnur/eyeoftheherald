package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;

import javax.persistence.*;

@Data
@Entity
public class ChampionPassive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;
    String name;
    String description;
    @OneToOne(cascade = CascadeType.ALL)
    GameSprite sprite;
}
