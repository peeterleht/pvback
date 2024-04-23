package com.valiit.pvback.business.timelog;

import com.valiit.pvback.business.timelog.dto.TimeLogInfo;
import com.valiit.pvback.domain.project.timelog.TimeLog;
import com.valiit.pvback.domain.project.timelog.TimeLogMapper;
import com.valiit.pvback.domain.project.timelog.TimeLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@AllArgsConstructor
public class TimeLogService {
    private final TimeLogMapper timeLogMapper;
    private final TimeLogRepository timeLogRepository;

    public void saveUserWorkHours(TimeLogInfo timeLogInfo){
        TimeLog timeLog = timeLogMapper.toTimeLogInfo(timeLogInfo);
        Instant instant = timeLogInfo.getTimestamp().toInstant();
        timeLog.setTimestamp(instant);
        timeLogRepository.save(timeLog);

    }
}
