package com.valiit.pvback.business.project;

import com.valiit.pvback.domain.project.Project;
import com.valiit.pvback.domain.project.ProjectMapper;
import com.valiit.pvback.domain.project.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;

    public void createAndSaveProject(ProjectInfo projectInfo) {
        Project project = projectMapper.toProject(projectInfo);
        projectRepository.save(project);
    }

    public List<ProjectInfo> getAllCompanyProjects() {
        List<Project> projects = projectRepository.findAll();
        return projectMapper.toProjectInfos(projects);
    }

}
