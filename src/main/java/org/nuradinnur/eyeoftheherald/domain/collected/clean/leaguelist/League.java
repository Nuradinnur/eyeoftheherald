package org.nuradinnur.eyeoftheherald.domain.collected.clean.leaguelist;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.RankedQueues;
import org.nuradinnur.eyeoftheherald.constant.Tiers;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class League {
    @Id
    @Column(length = 200)
    private String leagueId;
    @Enumerated
    private RankedQueues queue;
    private LocalDateTime dateRetrieved;
    @Enumerated
    private Tiers tier;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<LeagueEntry> players;
}
