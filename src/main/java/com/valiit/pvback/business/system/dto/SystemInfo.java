package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.System;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link System}
 */
@Data
public class SystemInfo implements Serializable {
    String systemName;
    String systemMoto;
    byte[] systemImageData;
}