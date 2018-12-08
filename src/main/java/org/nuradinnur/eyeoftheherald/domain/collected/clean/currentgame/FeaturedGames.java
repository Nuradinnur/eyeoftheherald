package org.nuradinnur.eyeoftheherald.domain.collected.clean.currentgame;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
public class FeaturedGames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private ZonedDateTime dateRetrieved;
    private Long refreshInterval;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CurrentGame> games;
}
