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
    private Integer id;
    private String name;
    private String imageFileName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rune> keystones;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rune> tier1;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rune> tier2;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rune> tier3;
}
