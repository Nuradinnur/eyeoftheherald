package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchlist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private Integer numberOfGames;
    private Integer startMatchIndex;
    private Integer endMatchIndex;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MatchReference> matchReferences;
}
