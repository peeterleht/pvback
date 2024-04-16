package com.valiit.pvback.business.project;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.valiit.pvback.domain.project.Project}
 */
@Data
public class ProjectInfo implements Serializable {
    private String projectCode;
    private String projectName;
    private String projectClient;
    private String projectBankLink;
}
