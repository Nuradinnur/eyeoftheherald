package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.rune;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class RunePath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String spriteFileName;
    @ElementCollection
    List<Integer> keystones;
    @ElementCollection
    List<Integer> tier1;
    @ElementCollection
    List<Integer> tier2;
    @ElementCollection
    List<Integer> tier3;
}
