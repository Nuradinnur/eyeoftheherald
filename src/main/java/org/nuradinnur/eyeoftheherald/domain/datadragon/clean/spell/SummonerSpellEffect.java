package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell;

import lombok.Data;
import lombok.experimental.NonFinal;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SummonerSpellEffect {
    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ElementCollection
    List<Double> effects;
}
