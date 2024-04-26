package com.valiit.pvback.domain.process;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcessRepository extends JpaRepository<Process, Integer> {
    @Query("select p from Process p where p.project.id = :projectId order by p.project.id")
    List<Process> findAllProcessesBy(Integer projectId);
}