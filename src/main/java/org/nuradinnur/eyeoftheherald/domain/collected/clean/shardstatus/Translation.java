package org.nuradinnur.eyeoftheherald.domain.collected.clean.shardstatus;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String locale;
    private String content;
    private String updatedAt;
}
