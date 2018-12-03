package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.champion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class SpellRankUpgrades {
    @Id
    @Column(length = 100)
    @JsonIgnore
    private String forSpell;
    @ElementCollection
    private List<String> label;
    @ElementCollection
    private List<String> effect;
}
