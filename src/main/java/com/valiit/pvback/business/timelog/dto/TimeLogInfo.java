package com.valiit.pvback.business.timelog.dto;

import com.valiit.pvback.domain.project.timelog.TimeLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link TimeLog}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeLogInfo implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer projectId;
    private Integer minutes;
    private Timestamp timestamp;

}