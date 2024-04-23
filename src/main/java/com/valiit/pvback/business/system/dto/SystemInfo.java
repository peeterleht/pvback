package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.System;
import lombok.Data;

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