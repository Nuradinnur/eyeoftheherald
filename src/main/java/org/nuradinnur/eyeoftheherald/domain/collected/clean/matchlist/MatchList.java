package org.nuradinnur.eyeoftheherald.domain.collected.clean.matchlist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class MatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private List<MatchReference> matchReferences;
    private Integer numberOfGames;
    private Integer startMatchIndex;
    private Integer endMatchIndex;
}
