package com.valiit.pvback.business.project;


import com.valiit.pvback.business.project.dto.ProjectInfo;
import com.valiit.pvback.business.timelog.dto.TimeLogInfo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/project")
    public void addProject(@RequestBody @Valid ProjectInfo projectInfo) {
        projectService.createAndSaveProject(projectInfo);
    }

    @GetMapping("/projects")
    public List<ProjectInfo> viewProjects() {
        return projectService.getAllCompanyProjects();
    }

    @GetMapping("/projects/companyuser/{userId}")
    public void getAllCompanyUserProjects(@PathVariable Integer userId){
        projectService.getAllCompanyUserProjects(userId);
    }
}
