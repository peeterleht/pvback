package com.valiit.pvback.domain.project;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.project.ProjectInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {

    @Mapping(source = "projectCode", target = "code")
    @Mapping(source = "projectName", target = "name")
    @Mapping(source = "projectClient", target = "client")
    @Mapping(source = "projectBankLink", target = "bankLink")
    @Mapping(constant = Status.ACTIVE, target = "status")
    Project toProject(ProjectInfo projectInfo);
}