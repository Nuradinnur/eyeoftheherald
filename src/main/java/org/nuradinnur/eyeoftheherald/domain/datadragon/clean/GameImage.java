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
    private String fileName;
    private String spriteSheetFileName;
    private String spriteGroup;
    private Integer offsetX;
    private Integer offsetY;
    private Integer width;
    private Integer height;
}
