package org.nuradinnur.eyeoftheherald.domain.datadragon.clean;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SpellVars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String toolTipLocation;
    private String scalingVariable;
    @ElementCollection
    private List<Double> scalingCoefficients;
}
