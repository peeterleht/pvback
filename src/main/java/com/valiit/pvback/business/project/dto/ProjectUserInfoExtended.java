package com.valiit.pvback.business.project.dto;

import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ProjectUser}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUserInfoExtended extends ProjectUserInfo {
    private Integer id;
    private Integer projectRoleId;
    private String projectRoleName;
}