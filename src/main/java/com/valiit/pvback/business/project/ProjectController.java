package com.valiit.pvback.business.project;


import com.valiit.pvback.business.project.dto.ProjectGeneralInfo;
import com.valiit.pvback.business.project.dto.ProjectInfo;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Toob ära kõik kasutaja projektid, milles ta osaleb")
    public List<ProjectGeneralInfo> getAllCompanyUserProjects(@PathVariable Integer userId){
        return projectService.getAllCompanyUserProjects(userId);
    }
}
