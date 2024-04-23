package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.advert.SysAdvert;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link SysAdvert}
 */
@Data
public class SysAdvertInfo implements Serializable {
    Integer sysAdvertId;
    String sysAdvertSide;
    String sysAdvertText;
    byte[] sysAdvertImageData;
    String sysAdvertStatus;
}