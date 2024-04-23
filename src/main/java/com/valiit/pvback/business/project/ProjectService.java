package com.valiit.pvback.business.project;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.project.dto.ProjectGeneralInfo;
import com.valiit.pvback.business.project.dto.ProjectInfo;
import com.valiit.pvback.business.project.dto.ProjectUserInfo;
import com.valiit.pvback.domain.project.Project;
import com.valiit.pvback.domain.project.ProjectMapper;
import com.valiit.pvback.domain.project.ProjectRepository;
import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import com.valiit.pvback.domain.project.projectuser.ProjectUserMapper;
import com.valiit.pvback.domain.project.projectuser.ProjectUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;
    private final ProjectUserMapper projectUserMapper;
    private final ProjectUserRepository projectUserRepository;

    public void createAndSaveProject(ProjectInfo projectInfo) {
        Project project = projectMapper.toProject(projectInfo);
        projectRepository.save(project);
    }

    public List<ProjectInfo> getAllCompanyProjects() {
        List<Project> projects = projectRepository.findAll();
        return projectMapper.toProjectInfos(projects);
    }

    public List<ProjectGeneralInfo> getAllCompanyUserProjects(Integer userId) {
        List<ProjectGeneralInfo> projectGeneralInfos = getProjectGeneralInfosBy(userId);
        addProjectUserInfos(projectGeneralInfos);
        return projectGeneralInfos;
    }

    private List<ProjectGeneralInfo> getProjectGeneralInfosBy(Integer userId) {
        List<Project> projects = projectUserRepository.findProjectsBy(userId, Status.ACTIVE);
        return projectMapper.toProjectGeneralInfos(projects);
    }

    private void addProjectUserInfos(List<ProjectGeneralInfo> projectGeneralInfos) {
        for (ProjectGeneralInfo projectGeneralInfo : projectGeneralInfos) {
            List<ProjectUser> projectUsers = projectUserRepository.findProjectUsersBy(projectGeneralInfo.getProjectId(), Status.ACTIVE);
            List<ProjectUserInfo> projectUserInfos = projectUserMapper.toProjectUserInfos(projectUsers);
            projectGeneralInfo.setProjectUserInfos(projectUserInfos);
        }
    }
}
