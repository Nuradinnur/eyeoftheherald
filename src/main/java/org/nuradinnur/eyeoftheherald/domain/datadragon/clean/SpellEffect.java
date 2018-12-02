package org.nuradinnur.eyeoftheherald.domain.datadragon.clean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SpellEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;
    @ElementCollection
    List<Double> effects;
}
