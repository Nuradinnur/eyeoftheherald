package org.nuradinnur.eyeoftheherald.domain.collected.dto.shardstatus;

import lombok.Data;

import java.util.List;

@Data
class IncidentDTO {
    private Boolean active;
    private String created_at;
    private Long id;
    private List<MessageDTO> updates;
}
