package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ChampionRating {
    @Id
    @JsonIgnore
    Integer id;
    Integer attack;
    Integer defense;
    Integer magic;
    Integer difficulty;
}
