package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.advert.SysAdvert;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link SysAdvert}
 */
@Value
public class SysAdvertInfo implements Serializable {
    String sysAdvertSide;
    String sysAdvertText;
    byte[] sysAdvertImageData;
    String sysAdvertStatus;
}