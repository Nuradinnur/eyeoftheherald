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
    private Integer id;
    private Integer attack;
    private Integer defense;
    private Integer magic;
    private Integer difficulty;
}
