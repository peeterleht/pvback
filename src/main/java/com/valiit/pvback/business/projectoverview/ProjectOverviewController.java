package com.valiit.pvback.business.projectoverview;

import com.valiit.pvback.business.projectoverview.dto.ProjectOverviewInfos;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProjectOverviewController {

    private final ProjectOverviewService projectOverviewService;

    @GetMapping("/project/overview")
    public ProjectOverviewInfos getProjectOverview(@RequestParam Integer projectId) {
        return projectOverviewService.getProjectOverview(projectId);
    }
}
