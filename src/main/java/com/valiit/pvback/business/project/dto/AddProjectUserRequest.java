package com.valiit.pvback.business.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.valiit.pvback.domain.project.projectuser.ProjectUser}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProjectUserRequest implements Serializable {
    @NotNull
    private Integer userId;
    @NotNull
    private Integer projectRoleId;
    @NotNull
    private Integer projectId;
    @NotNull
    @Size(max = 6)
    private String colorRgb;
    @NotNull
    private String status;
}