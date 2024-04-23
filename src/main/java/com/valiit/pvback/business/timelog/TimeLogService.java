package com.valiit.pvback.business.timelog;

import com.valiit.pvback.business.timelog.dto.TimeLogRequest;
import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import com.valiit.pvback.domain.project.projectuser.ProjectUserRepository;
import com.valiit.pvback.domain.project.timelog.TimeLog;
import com.valiit.pvback.domain.project.timelog.TimeLogMapper;
import com.valiit.pvback.domain.project.timelog.TimeLogRepository;
import com.valiit.pvback.domain.user.User;
import com.valiit.pvback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TimeLogService {
    private final TimeLogMapper timeLogMapper;
    private final TimeLogRepository timeLogRepository;
    private final ProjectUserRepository projectUserRepository;

    public void updateTimeLog(Integer timeLogId, TimeLogRequest timeLogRequest){
        TimeLog timeLog = timeLogRepository.getReferenceById(timeLogId);
        timeLogMapper.partialUpdate(timeLogRequest, timeLog);
        timeLogRepository.save(timeLog);
    }

    public void addTimeLog(Integer userId, Integer projectId) {
        ProjectUser projectUser = projectUserRepository.findProjectUserBy(userId, projectId);
        TimeLog timeLog = timeLogMapper.toTimeLog(projectUser);
        timeLogRepository.save(timeLog);
    }
}
