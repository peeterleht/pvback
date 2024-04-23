package com.valiit.pvback.domain.system;

import com.valiit.pvback.business.system.dto.SystemInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SystemMapper {
    @Mapping(source = "name", target = "systemName")
    @Mapping(source = "moto", target = "systemMoto")
    @Mapping(source = "imageData", target = "systemImageData")
    SystemInfo toSystemInfo(System system);

    @Mapping(source = "systemName",target = "name")
    @Mapping(source = "systemMoto",target = "moto")
    //@Mapping(source = "systemImageData",target = "imageData")
    void updateSystemData(SystemInfo systemInfo, @MappingTarget System systemData);
}