package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.List;

@Data
@Entity
@IdClass(CurrentGameParticipantId.class)
public class CurrentGameParticipant {
    @Id
    private Long gameId;
    @Id
    private Long summonerId;
    private String summonerName;
    private Integer summonerIconId;
    private Integer championId;
    private List<Integer> summonerSpells;
    private List<Integer> runes;
    private Integer primaryRuneTree;
    private Integer secondaryRuneTree;
    private Boolean isOnBlueSide;
    private Boolean isBot;
    private List<GameCustomization> gameCustomizations;
}
