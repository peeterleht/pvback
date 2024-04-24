package com.valiit.pvback.domain.project.timelog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimeLogRepository extends JpaRepository<TimeLog, Integer> {


    @Query("select t from TimeLog t where t.user.id = :id")
    List<TimeLog> findTimeLogsBy(@Param("id") Integer id);
}