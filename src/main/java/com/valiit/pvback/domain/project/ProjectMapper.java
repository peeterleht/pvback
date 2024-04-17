package com.valiit.pvback.domain.project;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.project.dto.ProjectInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {

    @Mapping(source = "projectCode", target = "code")
    @Mapping(source = "projectName", target = "name")
    @Mapping(source = "projectClient", target = "client")
    @Mapping(source = "projectBankLink", target = "bankLink")
    @Mapping(constant = Status.ACTIVE, target = "status")
    Project toProject(ProjectInfo projectInfo);

    @Mapping(source = "code", target = "projectCode")
    @Mapping(source = "name", target = "projectName")
    @Mapping(source = "client", target = "projectClient")
    @Mapping(source = "bankLink", target = "projectBankLink")
    ProjectInfo toProjectInfo(Project project);

    List<ProjectInfo> toProjectInfos(List<Project> projects);
}