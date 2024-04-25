package com.valiit.pvback.business.project;


import com.valiit.pvback.business.project.dto.AddProjectUserRequest;
import com.valiit.pvback.business.project.dto.ProjectGeneralInfo;
import com.valiit.pvback.business.project.dto.ProjectInfo;
import com.valiit.pvback.business.project.dto.ProjectUserInfoExtended;
import com.valiit.pvback.domain.process.ProcessInfo;
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
    @GetMapping("/projects/companyusers/{projectId}")
    @Operation(summary = "Toob ära kõik kasutajad, kes osalevad valitud projektis",
    description = "Kande tulemus: leitakse andmevaasist kõik kasutajad, kes on seotud valitud projektiga")

    public List<ProjectUserInfoExtended> getCompanyUsersInProject(@PathVariable Integer projectId) {
        return projectService.getProjectUsers(projectId);

    }

    @GetMapping("/projectRoles")
    public void getAllProjectRoles() {
        projectService.getAllProjectRoles();
    }

    @GetMapping("/project/process/{projectId}")
    public List<ProcessInfo> getAllProjectProcesses(Integer projectId) {
        return projectService.getAllProjectProcesses(projectId);

    }

//    @GetMapping("/project/process-part/{projectUserId}")
//    public void getAllProjectUserProcessParts(Integer projectUserId) {
//        projectService.getAllProjectProcessParts(projectUserId);
//    }



    @PostMapping("/project/user")
    public void addProjectUser(@RequestBody AddProjectUserRequest request) {
        projectService.addProjectUser(request);
    }
}
