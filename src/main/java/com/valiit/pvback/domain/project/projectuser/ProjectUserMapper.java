package com.valiit.pvback.domain.project.projectuser;

import com.valiit.pvback.business.project.dto.ProjectUserInfo;
import com.valiit.pvback.business.project.dto.ProjectUserInfoExtended;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectUserMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "colorRgb", target = "userRgb")
    ProjectUserInfo toProjectUserInfo(ProjectUser projectUser);


    List<ProjectUserInfo> toProjectUserInfos(List<ProjectUser> projectUsers);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "colorRgb", target = "userRgb")
    @Mapping(source = "id",target = "id")
    @Mapping(source = "projectRole.id",target = "projectRoleId")
    @Mapping(source = "projectRole.name",target = "projectRoleName")
    @Named(value = "useMe")
    ProjectUserInfoExtended toExtendedProjectUserInfo(ProjectUser projectUser);

    @IterableMapping(qualifiedByName = "useMe")
    List<ProjectUserInfoExtended> toExtendedProjectUserInfos(List<ProjectUser> projectUsers);

}