package com.valiit.pvback.domain.process;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Process}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessInfo implements Serializable {
    private Integer id;
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String description;
    private Integer projectRoleId;
    private String projectRoleName;
    private String status;
}