package org.nuradinnur.eyeoftheherald.domain.collected.clean.shardstatus;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String name;
    private String slug;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Incident> incidents;
}
