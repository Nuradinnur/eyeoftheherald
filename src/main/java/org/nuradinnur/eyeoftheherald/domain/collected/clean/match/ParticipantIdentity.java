package org.nuradinnur.eyeoftheherald.domain.collected.clean.match;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Regions;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(ParticipantIdentityId.class)
public class ParticipantIdentity {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    private Integer participantId;
    @Enumerated
    private Regions currentRegion;
    @Enumerated
    private Regions originalRegion;
    private Long currentAccountId;
    private Long originalAccountId;
    private Long summonerId;
    private String summonerName;
    private Integer summonerIconId;
}
