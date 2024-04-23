package com.valiit.pvback.domain.project.timelog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeLogRepository extends JpaRepository<TimeLog, Integer> {
}