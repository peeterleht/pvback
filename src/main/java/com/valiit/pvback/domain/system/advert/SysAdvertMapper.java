package com.valiit.pvback.domain.system.advert;

import com.valiit.pvback.business.system.dto.SysAdvertInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysAdvertMapper {
    @Mapping(source = "id", target = "sysAdvertId")
    @Mapping(source = "text", target = "sysAdvertText")
    @Mapping(source = "imageData", target = "sysAdvertImageData")
    @Mapping(source = "side", target = "sysAdvertSide")
    @Mapping(source = "status", target = "sysAdvertStatus")
    SysAdvertInfo toSysAdvertInfo(SysAdvert sysAdvert);

    List<SysAdvertInfo> toSysAdvertInfos(List<SysAdvert> sysAdverts);

    @Mapping(source = "sysAdvertText", target = "text")
    @Mapping(source = "sysAdvertImageData", target = "imageData")
    @Mapping(source = "sysAdvertSide", target = "side")
    @Mapping(source = "sysAdvertStatus", target = "status")
    SysAdvert toSysAdvert(SysAdvertInfo sysAdvertInfo);

    @InheritInverseConfiguration(name = "toSysAdvertInfo")
    void updateSysAdvertInfo(SysAdvertInfo sysAdvertInfo, @MappingTarget SysAdvert sysAdvert);
}