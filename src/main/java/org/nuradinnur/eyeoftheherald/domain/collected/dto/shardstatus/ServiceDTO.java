package org.nuradinnur.eyeoftheherald.domain.collected.dto.shardstatus;

import lombok.Data;

import java.util.List;

@Data
class ServiceDTO {
    private String status;
    private String name;
    private String slug;
    private List<IncidentDTO> incidents;
}
