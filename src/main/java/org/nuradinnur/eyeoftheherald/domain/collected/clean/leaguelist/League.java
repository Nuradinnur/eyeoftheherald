package org.nuradinnur.eyeoftheherald.domain.collected.clean.leaguelist;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.RankedQueues;
import org.nuradinnur.eyeoftheherald.constant.Tiers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class League {
    @Id
    @Column(length = 200)
    private String leagueId;
    private LocalDateTime dateRetrieved;
    private RankedQueues queue;
    private Tiers tier;
    private String name;
    private List<LeagueEntry> players;
}
