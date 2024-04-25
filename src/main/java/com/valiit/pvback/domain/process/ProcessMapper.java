package com.valiit.pvback.domain.process;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProcessMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "projectRole.id", target = "projectRoleId")
    @Mapping(source = "projectRole.name", target = "projectRoleName")
    @Mapping(source = "status", target = "status")
    ProcessInfo toProcessInfo(Process process);

    List<ProcessInfo> toProcessInfos(List<Process> processes);
}