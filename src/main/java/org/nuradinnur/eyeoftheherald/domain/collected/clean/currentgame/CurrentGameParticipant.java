package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@IdClass(CurrentGameParticipantId.class)
public class CurrentGameParticipant {
    @Id
    @JsonIgnore
    private Long gameId;
    @Id
    private Long summonerId;
    private String summonerName;
    private Integer summonerIconId;
    private Integer championId;
    @ElementCollection
    private List<Integer> summonerSpells;
    @ElementCollection
    private List<Integer> runes;
    private Integer primaryRuneTree;
    private Integer secondaryRuneTree;
    private Boolean isOnBlueSide;
    private Boolean isBot;
    @OneToMany(cascade = CascadeType.ALL)
    private List<GameCustomization> gameCustomizations;
}
