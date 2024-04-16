package com.valiit.pvback.business.project;

import com.valiit.pvback.domain.project.Project;
import com.valiit.pvback.domain.project.ProjectMapper;
import com.valiit.pvback.domain.project.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;

    @Transactional
    public void createAndSaveProject(ProjectInfo projectInfo) {
        Project project = projectMapper.toProject(projectInfo);
        projectRepository.save(project);

    }
}
