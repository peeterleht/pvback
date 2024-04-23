package com.valiit.pvback.domain.project.timelog;

import com.valiit.pvback.business.timelog.dto.TimeLogInfo;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.time.Instant;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TimeLogMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "minutes", target = "minutes")
    @Mapping(source ="timestamp" ,target ="timestamp" )
    TimeLog toTimeLogInfo(TimeLogInfo timeLogInfo);
    default Instant map(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toInstant();
    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TimeLog partialUpdate(TimeLogInfo timeLogInfo, @MappingTarget TimeLog timeLog);
}