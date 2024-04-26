package com.valiit.pvback.business.projectoverview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectOverviewInfos {
    private List<ProcessInfo> processInfos;
    private List<PartInfo> partInfos;
}
