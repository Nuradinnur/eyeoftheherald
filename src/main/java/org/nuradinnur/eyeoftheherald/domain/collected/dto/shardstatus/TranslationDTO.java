package org.nuradinnur.eyeoftheherald.domain.collected.dto.shardstatus;

import lombok.Data;

@Data
class TranslationDTO {
    private String locale;
    private String content;
    private String updated_at;
}
