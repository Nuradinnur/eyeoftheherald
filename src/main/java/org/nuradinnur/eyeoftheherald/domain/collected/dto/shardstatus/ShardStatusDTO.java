package org.nuradinnur.eyeoftheherald.domain.collected.dto.shardstatus;

import lombok.Data;

import java.util.List;

@Data
public class ShardStatusDTO {
    private String name;
    private String region_tag;
    private String hostname;
    private List<ServiceDTO> services;
    private String slug;
    private List<String> locales;
}
