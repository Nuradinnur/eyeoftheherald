package org.nuradinnur.eyeoftheherald.domain.datadragon.clean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class GameSprite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String suggestedFileName;
    String spriteSheetFileName;
    String spriteGroup;
    Integer offsetX;
    Integer offsetY;
    Integer width;
    Integer height;
}
