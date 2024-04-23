package com.valiit.pvback.domain.project.projectuser;

import com.valiit.pvback.business.project.dto.ProjectGeneralInfo;
import com.valiit.pvback.business.project.dto.ProjectUserInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectUserMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "colorRgb", target = "userRgb")
    ProjectUserInfo toProjectUserInfo(ProjectUser projectUser);


    List<ProjectUserInfo> toProjectUserInfos(List<ProjectUser> projectUsers);

}