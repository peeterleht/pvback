package com.valiit.pvback.domain.project.projectrole;

import com.valiit.pvback.business.project.dto.ProjectRoleInfo;
import com.valiit.pvback.domain.project.projectrole.ProjectRole;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectRoleMapper {

    @Mapping(source = "id", target = "projectRoleId")
    @Mapping(source = "name", target = "projectRoleName")
    ProjectRoleInfo toProjectRoleInfo(ProjectRole projectRole);

    List<ProjectRoleInfo> toProjectRoleInfos(List<ProjectRoleInfo> projectRoleInfos);
}