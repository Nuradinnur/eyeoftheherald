package org.nuradinnur.eyeoftheherald.domain.datadragon.clean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class GameSprite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;
    String suggestedFileName;
    String spriteSheetFileName;
    String spriteGroup;
    Integer offsetX;
    Integer offsetY;
    Integer width;
    Integer height;
}
