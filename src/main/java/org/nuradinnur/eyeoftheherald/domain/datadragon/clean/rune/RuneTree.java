package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.rune;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class RuneTree {
    @Id
    Integer id;
    String name;
    String imageFileName;
    @OneToMany(cascade = CascadeType.ALL)
    List<Rune> keystones;
    @OneToMany(cascade = CascadeType.ALL)
    List<Rune> tier1;
    @OneToMany(cascade = CascadeType.ALL)
    List<Rune> tier2;
    @OneToMany(cascade = CascadeType.ALL)
    List<Rune> tier3;
}
