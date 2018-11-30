package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class LevelTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ElementCollection
    List<String> label;
    @ElementCollection
    List<String> effect;
}
