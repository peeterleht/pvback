package com.valiit.pvback.domain.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Override
    Optional<Project> findById(Integer integer);
}