package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.tryout.SysTryOut;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link SysTryOut}
 */
@Data
public class SysTryOutInfo implements Serializable {
    String sysTryOutHeader;
    String sysTryOutText;
    String sysTryOutButtonText;
}