package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(GameCustomizationId.class)
public
class GameCustomization {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    private Long summonerId;
    private String category;
    private String content;
}
