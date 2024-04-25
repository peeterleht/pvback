package com.valiit.pvback.business.project.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.valiit.pvback.domain.project.projectrole.ProjectRole}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRoleInfo implements Serializable {
    private Integer projectRoleId;
    @Size(max = 255)
    private String projectRoleName;
}