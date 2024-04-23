package com.valiit.pvback.business.project.dto;

import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link ProjectUser}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectGeneralInfo implements Serializable {
    private Integer projectId;
    private String projectCode;
    private String projectName;
    private String clientName;
    private String bankLink;
    private List<ProjectUserInfo> projectUserInfos;
}