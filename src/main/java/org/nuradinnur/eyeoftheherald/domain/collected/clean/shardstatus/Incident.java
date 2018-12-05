package org.nuradinnur.eyeoftheherald.domain.collected.clean.shardstatus;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
class Incident {
    @Id
    private Long id;
    private Boolean active;
    private String createdAt;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> updates;
}
