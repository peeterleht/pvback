package com.valiit.pvback.domain.project.projectuser;

import com.valiit.pvback.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectUserRepository extends JpaRepository<ProjectUser, Integer> {

    @Query("select p from ProjectUser p where p.project.id = :projectId and p.status = :status order by p.id")
    List<ProjectUser> findProjectUsersBy(Integer projectId, String status);

    @Query("select distinct p.project from ProjectUser p where p.user.id = :userId and  p.project.status = :status")
    List<Project> findProjectsBy(Integer userId, String status);

    @Query("select p from ProjectUser p where p.user.id = :userId and p.project.id = :projectId")
    ProjectUser findProjectUserBy(Integer userId, Integer projectId);


}