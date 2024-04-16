package com.valiit.pvback.business.project;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/project")
    public void addProject(@RequestBody @Valid ProjectInfo projectInfo) {
        projectService.createAndSaveProject(projectInfo);
    }
}
