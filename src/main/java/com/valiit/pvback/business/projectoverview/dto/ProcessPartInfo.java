package com.valiit.pvback.business.projectoverview.dto;

import com.valiit.pvback.business.project.dto.ProjectUserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPartInfo {
    private Integer processPartId;
    private String status;

    private Boolean userAssigned;
    private ProjectUserInfo projectUserInfo;

}
