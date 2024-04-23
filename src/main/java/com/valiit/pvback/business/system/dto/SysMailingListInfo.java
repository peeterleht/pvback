package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.mailinglist.SysMailingList;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link SysMailingList}
 */
@Data
public class SysMailingListInfo implements Serializable {
    String sysMailingListEmail;
}