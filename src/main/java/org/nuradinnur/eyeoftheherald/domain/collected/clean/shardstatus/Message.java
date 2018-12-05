package org.nuradinnur.eyeoftheherald.domain.collected.clean.shardstatus;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
class Message {
    @Id
    @Column(length = 100)
    private String id;
    private String createdAt;
    private String updatedAt;
    private String author;
    private String severity;
    private String content;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Translation> translations;
}
