package org.nuradinnur.eyeoftheherald.domain.collected.dto.shardstatus;

import lombok.Data;

import java.util.List;

@Data
class MessageDTO {
    private String severity;
    private String author;
    private String created_at;
    private List<TranslationDTO> translations;
    private String updated_at;
    private String content;
    private String id;
}
