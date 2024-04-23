package com.valiit.pvback.business.project;


import com.valiit.pvback.business.project.dto.ProjectGeneralInfo;
import com.valiit.pvback.business.project.dto.ProjectInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/project")
    @Operation(summary = "Uue projekti lisamine",
            description = "Kande tulemus: andmebaasi lisatakse uus projekt")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public void addProject(@RequestBody @Valid ProjectInfo projectInfo) {
        projectService.createAndSaveProject(projectInfo);
    }

    @GetMapping("/projects")
    @Operation(summary = "Kõikide projektide otsimine",
            description = "Kande tulemus: leitakse andmebaasist kõik projektid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<ProjectInfo> viewProjects() {
        return projectService.getAllCompanyProjects();
    }

    @GetMapping("/projects/companyuser/{userId}")
    @Operation(summary = "Toob ära kõik kasutaja projektid, milles ta osaleb",
            description = "Kande tulemus: leitakse andmebaasist kõik projektid, kus see kasutaja osaleb")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<ProjectGeneralInfo> getAllCompanyUserProjects(@PathVariable Integer userId){
        return projectService.getAllCompanyUserProjects(userId);
    }
}
