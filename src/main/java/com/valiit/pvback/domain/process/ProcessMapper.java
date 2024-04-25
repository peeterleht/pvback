package com.valiit.pvback.domain.process;

import com.valiit.pvback.business.projectoverview.dto.ProcessInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProcessMapper {

    @Mapping(source = "id", target = "processId")
    @Mapping(source = "name", target = "processName")
    ProcessInfo toProcessInfo(Process process);

    List<ProcessInfo> toProcessInfos(List<Process> processes);
}