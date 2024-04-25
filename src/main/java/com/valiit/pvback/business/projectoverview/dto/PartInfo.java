package com.valiit.pvback.business.projectoverview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartInfo {
    private Integer partId;
    private Integer volume;
    private String partName;
    private Integer deadlineWeek;
    private List<ProcessPartInfo> processPartInfos;

}
