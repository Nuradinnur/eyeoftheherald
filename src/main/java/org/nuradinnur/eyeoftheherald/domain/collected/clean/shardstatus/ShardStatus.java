package org.nuradinnur.eyeoftheherald.domain.collected.clean.shardstatus;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.nuradinnur.eyeoftheherald.constant.Regions;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ShardStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    @Enumerated
    private Regions region;
    private String hostname;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Service> services;
    @ElementCollection
    private List<Locales> locales;
}
