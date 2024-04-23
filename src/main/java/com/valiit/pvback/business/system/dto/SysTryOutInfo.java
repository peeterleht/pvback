package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.tryout.SysTryOut;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link SysTryOut}
 */
@Value
public class SysTryOutInfo implements Serializable {
    String sysTryOutHeader;
    String sysTryOutText;
    String sysTryOutButtonText;
}