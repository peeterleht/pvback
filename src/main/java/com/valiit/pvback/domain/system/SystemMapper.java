package com.valiit.pvback.domain.system;

import com.valiit.pvback.business.system.dto.SystemInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SystemMapper {
    @Mapping(source = "name", target = "systemName")
    @Mapping(source = "moto", target = "systemMoto")
    @Mapping(source = "imageData", target = "systemImageData")
    SystemInfo toSystemInfo(System system);
}