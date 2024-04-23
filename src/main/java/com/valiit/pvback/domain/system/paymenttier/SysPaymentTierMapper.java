package com.valiit.pvback.domain.system.paymenttier;

import com.valiit.pvback.business.system.dto.SysPaymentTierInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysPaymentTierMapper {
    @Mapping(source = "id", target = "sysPaymentTierId")
    @Mapping(source = "subscriptionType.name", target = "sysPaymentTierSubscriptionTypeName")
    @Mapping(source = "priceMonth", target = "sysPaymentTierPriceMonth")
    @Mapping(source = "priceYear", target = "sysPaymentTierPriceYear")
    @Mapping(source = "textRow1", target = "sysPaymentTierTextRow1")
    @Mapping(source = "textRow2", target = "sysPaymentTierTextRow2")
    @Mapping(source = "textRow3", target = "sysPaymentTierTextRow3")
    @Mapping(source = "textRow4", target = "sysPaymentTierTextRow4")
    @Mapping(source = "textRow5", target = "sysPaymentTierTextRow5")
    @Mapping(source = "textRow6", target = "sysPaymentTierTextRow6")
    @Mapping(source = "textRow7", target = "sysPaymentTierTextRow7")
    @Mapping(source = "textRow8", target = "sysPaymentTierTextRow8")
    SysPaymentTierInfo toSysPaymentTierInfo(SysPaymentTier sysPaymentTier);

    List<SysPaymentTierInfo> toSysPaymentTierInfos(List<SysPaymentTier> sysPaymentTiers);

    @InheritInverseConfiguration
    void updateSysPaymentTierInfo(SysPaymentTierInfo sysPaymentTierInfo, @MappingTarget SysPaymentTier sysPaymentTier);
}