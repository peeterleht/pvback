package com.valiit.pvback.domain.project.timelog;

import com.valiit.pvback.business.timelog.dto.TimeLogRequest;
import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import com.valiit.pvback.util.LocalDateConverter;
import org.mapstruct.*;

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
}