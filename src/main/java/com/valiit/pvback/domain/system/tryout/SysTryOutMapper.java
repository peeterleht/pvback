package com.valiit.pvback.domain.system.tryout;

import com.valiit.pvback.business.system.dto.SysTryOutInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysTryOutMapper {
    @Mapping(source = "header", target = "sysTryOutHeader")
    @Mapping(source = "text", target = "sysTryOutText")
    @Mapping(source = "buttonText", target = "sysTryOutButtonText")
    SysTryOutInfo toSysTryOutInfo(SysTryOut sysTryOut);
}