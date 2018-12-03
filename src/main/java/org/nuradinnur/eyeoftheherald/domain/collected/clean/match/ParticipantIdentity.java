package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Regions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(ParticipantIdentityId.class)
public class ParticipantIdentity {
    @Id
    private Long gameId;
    @Id
    private Integer participantId;
    private Regions currentRegion;
    private Regions originalRegion;
    private Long currentAccountId;
    private Long originalAccountId;
    private Long summonerId;
    private String summonerName;
    private Integer summonerIcon;
}
