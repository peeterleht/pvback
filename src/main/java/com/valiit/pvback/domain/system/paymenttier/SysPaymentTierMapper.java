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

    @Mapping(source = "sysPaymentTierPriceMonth", target = "priceMonth")
    @Mapping(source = "sysPaymentTierPriceYear", target = "priceYear")
    @Mapping(source = "sysPaymentTierTextRow1", target = "textRow1")
    @Mapping(source = "sysPaymentTierTextRow2", target = "textRow2")
    @Mapping(source = "sysPaymentTierTextRow3", target = "textRow3")
    @Mapping(source = "sysPaymentTierTextRow4", target = "textRow4")
    @Mapping(source = "sysPaymentTierTextRow5", target = "textRow5")
    @Mapping(source = "sysPaymentTierTextRow6", target = "textRow6")
    @Mapping(source = "sysPaymentTierTextRow7", target = "textRow7")
    @Mapping(source = "sysPaymentTierTextRow8", target = "textRow8")
    SysPaymentTier toSysPaymentTier(SysPaymentTierInfo sysPaymentTierInfo);

    @InheritInverseConfiguration(name = "toSysPaymentTierInfo")
    void updateSysPaymentTierInfo(SysPaymentTierInfo sysPaymentTierInfo, @MappingTarget SysPaymentTier sysPaymentTier);
}