package com.valiit.pvback.business.projectoverview.dto;

import com.valiit.pvback.business.projectoverview.dto.PartInfo;
import com.valiit.pvback.domain.process.Process;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Process}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessInfo implements Serializable {
    private Integer processId;
    private String processName;

}