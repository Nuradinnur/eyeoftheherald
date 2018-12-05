package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchtimeline;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
class MatchParticipantFrame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalGold;
    private Integer teamScore;
    private Integer participantId;
    private Integer level;
    private Integer currentGold;
    private Integer minionsKilled;
    private Integer dominionScore;
    private Integer xp;
    private Integer jungleMinionsKilled;
    @OneToOne(cascade = CascadeType.ALL)
    private MatchPosition position;
}
