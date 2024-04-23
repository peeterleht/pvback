package com.valiit.pvback.business.timelog.dto;

import com.valiit.pvback.domain.project.timelog.TimeLog;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link TimeLog}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeLogRequest implements Serializable {
    @NotNull
    private Integer monday;
    @NotNull
    private Integer tuesday;
    @NotNull
    private Integer wednesday;
    @NotNull
    private Integer thursday;
    @NotNull
    private Integer friday;
}