package org.nuradinnur.eyeoftheherald.domain.datadragon.clean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class GameImage {
    @Id
    @Column(length = 200)
    String fileName;
    String spriteSheetFileName;
    String spriteGroup;
    Integer offsetX;
    Integer offsetY;
    Integer width;
    Integer height;
}
