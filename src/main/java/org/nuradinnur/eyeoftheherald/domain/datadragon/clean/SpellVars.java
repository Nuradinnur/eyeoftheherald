package org.nuradinnur.eyeoftheherald.domain.datadragon.clean;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SpellVars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String toolTipLocation;
    String scalingVariable;
    @ElementCollection
    List<Double> scalingCoefficients;
}
