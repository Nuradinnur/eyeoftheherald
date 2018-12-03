package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(GameCustomizationId.class)
class GameCustomization {
    @Id
    private Long gameId;
    @Id
    private Long summonerId;
    private String category;
    private String content;
}
