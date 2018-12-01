package org.nuradinnur.eyeoftheherald.domain.datadragon.clean;

import lombok.Data;
import lombok.experimental.NonFinal;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SpellVars {
    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String toolTipLocation;
    String scalingVariable;
    @ElementCollection
    List<Double> scalingCoefficients;
}
