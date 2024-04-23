package com.valiit.pvback.domain.system.projectexample;

import com.valiit.pvback.business.system.dto.SysProjectExampleInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysProjectExampleMapper {
    @Mapping(source = "id", target = "sysProjectExampleId")
    @Mapping(source = "name", target = "sysProjectExampleName")
    @Mapping(source = "text", target = "sysProjectExampleText")
    @Mapping(source = "project.id", target = "sysProjectExampleProjectId")
    SysProjectExampleInfo toSysProjectExampleInfo(SysProjectExample sysProjectExample);

    List<SysProjectExampleInfo> toSysProjectExampleInfos(List<SysProjectExample> sysProjectExamples);

    @InheritInverseConfiguration
    void updateSysProjectExampleInfo(SysProjectExampleInfo sysProjectExampleInfo, @MappingTarget SysProjectExample sysProjectExample);
}