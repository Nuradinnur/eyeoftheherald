package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@IdClass(MatchEventId.class)
class MatchEvent {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    private Integer participantId;
    private Boolean isOnBlueSide;
    private Long gameTime;
    private String type;
    private String laneType;
    private String eventType;
    private String towerType;
    private String buildingType;
    private String ascendedType;
    private String pointCaptured;
    private String wardType;
    private String monsterType;
    private String monsterSubType;
    private String levelUpType;
    private Integer skillSlot;
    private Integer itemId;
    private Integer victimId;
    private Integer killerId;
    private Integer creatorId;
    private Integer beforeId;
    private Integer afterId;
    @OneToOne(cascade = CascadeType.ALL)
    private MatchPosition position;
    @ElementCollection
    private List<Integer> assistingParticipantIds;
}
