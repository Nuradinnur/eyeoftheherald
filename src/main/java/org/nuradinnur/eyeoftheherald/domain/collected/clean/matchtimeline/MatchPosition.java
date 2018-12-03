package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(MatchPositionId.class)
class MatchPosition {
    @Id
    private Integer x;
    @Id
    private Integer y;
}
