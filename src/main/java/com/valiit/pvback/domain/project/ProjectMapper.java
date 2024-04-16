package com.valiit.pvback.domain.project;

import com.valiit.pvback.business.project.ProjectInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {

    @Mapping(source = "projectCode", target = "code")
    @Mapping(source = "projectName", target = "name")
    @Mapping(source = "projectClient", target = "client")
    @Mapping(source = "projectBankLink", target = "bankLink")
    Project toProject(ProjectInfo projectInfo);

    ProjectInfo toDto(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectInfo projectInfo, @MappingTarget Project project);
}