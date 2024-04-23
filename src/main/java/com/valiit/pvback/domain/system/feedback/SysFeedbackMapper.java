package com.valiit.pvback.domain.system.feedback;

import com.valiit.pvback.business.system.dto.SysFeedbackInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysFeedbackMapper {
    @Mapping(source = "id",target = "sysFeedbackId")
    @Mapping(source = "name",target = "sysFeedbackName")
    @Mapping(source = "text",target = "sysFeedbackText")
    SysFeedbackInfo toSysFeedbackInfo(SysFeedback sysFeedback);

    List<SysFeedbackInfo> toSysFeedbackInfos(List<SysFeedback> sysFeedbacks);
}