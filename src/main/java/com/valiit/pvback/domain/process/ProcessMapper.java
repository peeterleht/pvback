package com.valiit.pvback.domain.process;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProcessMapper {

    @Mapping(source = "", target = "name")
    @Mapping(source = "", target = "description")
    @Mapping(source = "", target = "projectRoleId")
    @Mapping(source = "", target = "projectRoleName")
    @Mapping(source = "status", target = "status")
    ProcessInfo toProcessInfo(Process process);
}