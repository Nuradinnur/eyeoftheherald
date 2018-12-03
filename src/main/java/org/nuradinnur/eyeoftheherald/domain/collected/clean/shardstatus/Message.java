package org.nuradinnur.eyeoftheherald.domain.collected.clean.shardstatus;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
class Message {
    @Id
    private String id;
    private String severity;
    private String author;
    private String created_at;
    private List<Translation> translations;
    private String updated_at;
    private String content;
}
