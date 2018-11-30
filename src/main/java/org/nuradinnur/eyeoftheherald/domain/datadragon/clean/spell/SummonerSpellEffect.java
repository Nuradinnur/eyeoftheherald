package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.spell;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
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
