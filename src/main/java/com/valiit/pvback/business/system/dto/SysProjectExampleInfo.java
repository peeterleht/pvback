package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.projectexample.SysProjectExample;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link SysProjectExample}
 */
@Data
public class SysProjectExampleInfo implements Serializable {
    Integer sysProjectExampleProjectId;
    String sysProjectExampleName;
    String sysProjectExampleText;
}