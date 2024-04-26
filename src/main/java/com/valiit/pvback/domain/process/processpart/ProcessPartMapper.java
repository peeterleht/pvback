package com.valiit.pvback.domain.process.processpart;

import com.valiit.pvback.business.project.dto.ProjectUserInfo;
import com.valiit.pvback.business.projectoverview.dto.ProcessPartInfo;
import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProcessPartMapper {


    @Mapping(source = "id", target = "processPartId")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "projectUser", target = "userAssigned", qualifiedByName = "projectUserToUserAssigned")
    @Mapping(source = "projectUser", target = "projectUserInfo", qualifiedByName = "projectUserToProjectUserInfo")
    ProcessPartInfo toProcessPartInfo(ProcessPart processPart);


    List<ProcessPartInfo> toProcessPartInfos(List<ProcessPart> processParts);

    @Named("projectUserToUserAssigned")
    static Boolean projectUserToUserAssigned(ProjectUser projectUser) {
        return projectUser != null;
    }

    @Named("projectUserToProjectUserInfo")
    static ProjectUserInfo projectUserToProjectUserInfo(ProjectUser projectUser) {
        if (projectUser == null) {
            return null;
        }
        return createProjectUserInfo(projectUser);
    }

    private static ProjectUserInfo createProjectUserInfo(ProjectUser projectUser) {
        ProjectUserInfo projectUserInfo = new ProjectUserInfo();
        projectUserInfo.setUserId(projectUser.getId());
        projectUserInfo.setUserName(projectUser.getUser().getName());
        projectUserInfo.setUserRgb(projectUser.getColorRgb());
         return projectUserInfo;
    }


}