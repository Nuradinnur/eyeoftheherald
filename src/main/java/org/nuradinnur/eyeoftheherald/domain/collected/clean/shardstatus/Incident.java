package org.nuradinnur.eyeoftheherald.domain.collected.clean.shardstatus;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
class Incident {
    @Id
    private Long id;
    private Boolean active;
    private String createdAt;
    private List<Message> updates;
}
