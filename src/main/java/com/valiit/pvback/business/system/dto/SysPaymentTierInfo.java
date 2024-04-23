package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.paymenttier.SysPaymentTier;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link SysPaymentTier}
 */
@Value
public class SysPaymentTierInfo implements Serializable {
    String sysPaymentTierSubscriptionTypeName;
    Integer sysPaymentTierPriceMonth;
    Integer sysPaymentTierPriceYear;
    String sysPaymentTierTextRow1;
    String sysPaymentTierTextRow2;
    String sysPaymentTierTextRow3;
    String sysPaymentTierTextRow4;
    String sysPaymentTierTextRow5;
    String sysPaymentTierTextRow6;
    String sysPaymentTierTextRow7;
    String sysPaymentTierTextRow8;
}