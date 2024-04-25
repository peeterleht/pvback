package com.valiit.pvback.business.timelog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeLogResponse implements Serializable
{
    private Integer timeLogId;
    private Integer userId;
    private Integer projectId;
    private String projectCode;
    private String projectName;
    private Integer monday;
    private Integer tuesday;
    private Integer wednesday;
    private Integer thursday;
    private Integer friday;
}
