package org.nuradinnur.eyeoftheherald.domain.collected.dto.matchtimeline;

import lombok.Data;

import java.util.List;

@Data
class MatchEventDTO {
    private String eventType;
    private String towerType;
    private Integer teamId;
    private String ascendedType;
    private Integer killerId;
    private String levelUpType;
    private String pointCaptured;
    private List<Integer> assistingParticipantIds;
    private String wardType;
    private String monsterType;
    private String type;
    private Integer skillSlot;
    private Integer victimId;
    private Long timestamp;
    private Integer afterId;
    private String monsterSubType;
    private String laneType;
    private Integer itemId;
    private Integer participantId;
    private String buildingType;
    private Integer creatorId;
    private MatchPositionDTO position;
    private Integer beforeId;
}
