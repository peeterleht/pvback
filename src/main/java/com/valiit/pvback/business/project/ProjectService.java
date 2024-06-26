package com.valiit.pvback.business.project;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.project.dto.*;
import com.valiit.pvback.business.projectoverview.dto.ProcessInfo;
import com.valiit.pvback.domain.process.*;
import com.valiit.pvback.domain.process.Process;
import com.valiit.pvback.domain.project.Project;
import com.valiit.pvback.domain.project.ProjectMapper;
import com.valiit.pvback.domain.project.ProjectRepository;
import com.valiit.pvback.domain.project.projectrole.ProjectRole;
import com.valiit.pvback.domain.project.projectrole.ProjectRoleMapper;
import com.valiit.pvback.domain.project.projectrole.ProjectRoleRepository;
import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import com.valiit.pvback.domain.project.projectuser.ProjectUserMapper;
import com.valiit.pvback.domain.project.projectuser.ProjectUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;
    private final ProjectUserMapper projectUserMapper;
    private final ProcessMapper processMapper;
    private final ProjectUserRepository projectUserRepository;
    private final ProcessRepository processRepository;
    private final ProjectRoleRepository projectRoleRepository;
    private final ProjectRoleMapper projectRoleMapper;

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

    public List<ProjectUserInfoExtended> getProjectUsers(Integer projectId) {
        List<ProjectUser> projectUsers = projectUserRepository.findProjectUsersBy(projectId);
        return projectUserMapper.toExtendedProjectUserInfos(projectUsers);
    }

    public void addProjectUser(@RequestBody AddProjectUserRequest request) {
        ProjectUser projectUser = projectUserMapper.toProjectUser(request);
        projectUserRepository.save(projectUser);
    }


    public List<ProjectRole> getAllProjectRoles() {
        return projectRoleRepository.findAll();
    }


}
