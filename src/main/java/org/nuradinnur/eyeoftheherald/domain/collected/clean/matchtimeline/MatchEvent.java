package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.List;

@Data
@Entity
@IdClass(MatchEventId.class)
class MatchEvent {
    @Id
    private Long gameId;
    @Id
    private Integer participantId;
    private Long timestamp;
    private Boolean isOnBlueSide;
    private Integer killerId;
    private String eventType;
    private String towerType;
    private String ascendedType;
    private String levelUpType;
    private String pointCaptured;
    private String wardType;
    private String monsterType;
    private String type;
    private Integer skillSlot;
    private Integer victimId;
    private Integer afterId;
    private String monsterSubType;
    private String laneType;
    private Integer itemId;
    private String buildingType;
    private Integer creatorId;
    private Integer beforeId;
    private List<Integer> assistingParticipantIds;
    private MatchPosition position;
}
