package org.nuradinnur.eyeoftheherald.domain.datadragon.clean.icon;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.domain.datadragon.clean.GameSprite;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class SummonerIcon {
    @Id
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private GameSprite image;
}
