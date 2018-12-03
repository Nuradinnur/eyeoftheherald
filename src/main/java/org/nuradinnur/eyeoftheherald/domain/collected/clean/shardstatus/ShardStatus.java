package org.nuradinnur.eyeoftheherald.domain.collected.clean.shardstatus;

import lombok.Data;
import org.nuradinnur.eyeoftheherald.constant.Locales;
import org.nuradinnur.eyeoftheherald.constant.Regions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class ShardStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private Regions region;
    private String hostname;
    private List<Service> services;
    private List<Locales> locales;
}
