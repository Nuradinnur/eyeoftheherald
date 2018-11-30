package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.NonFinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ChampionRating {
    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer attack;
    Integer defense;
    Integer magic;
    Integer difficulty;
}
