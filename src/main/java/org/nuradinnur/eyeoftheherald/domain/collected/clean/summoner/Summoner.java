package org.nuradinnur.eyeoftheherald.domain.collected.clean.summoner;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Summoner {
    @Id
    private Long accountId;
    private Long summonerId;
    private Long summonerLevel;
    private String name;
    private Integer profileIconId;
    private LocalDateTime revisionDate;
}
