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
}