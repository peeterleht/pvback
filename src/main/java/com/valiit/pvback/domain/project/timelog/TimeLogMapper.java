package com.valiit.pvback.domain.project.timelog;

import com.valiit.pvback.business.timelog.dto.TimeLogRequest;
import com.valiit.pvback.business.timelog.dto.TimeLogResponse;
import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import com.valiit.pvback.util.LocalDateConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {LocalDateConverter.class})
public interface TimeLogMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TimeLog partialUpdate(TimeLogRequest timeLogRequest, @MappingTarget TimeLog timeLog);


//    @Mapping(source = "", target = "user")
//    @Mapping(source = "", target = "project")
//



    @Mapping(constant = "0", target = "monday")
    @Mapping(constant = "0", target = "tuesday")
    @Mapping(constant = "0", target = "wednesday")
    @Mapping(constant = "0", target = "thursday")
    @Mapping(constant = "0", target = "friday")
    @Mapping(expression = "java(LocalDateConverter.getWeekNumberFromSystemDate())", target = "weekNumber")
    TimeLog toTimeLog(ProjectUser projectUser);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "project.id", target = "projectId")
    @Mapping(source = "monday", target = "monday")
    @Mapping(source = "tuesday", target = "tuesday")
    @Mapping(source = "wednesday", target = "wednesday")
    @Mapping(source = "thursday", target = "thursday")
    @Mapping(source = "friday", target = "friday")
    TimeLogResponse toTimeLogResponse(TimeLog timeLog);

    List<TimeLogResponse> toTimeLogResponses(List<TimeLog> timeLogs);
}