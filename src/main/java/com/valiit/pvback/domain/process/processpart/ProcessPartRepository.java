package com.valiit.pvback.domain.process.processpart;

import com.valiit.pvback.domain.process.part.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcessPartRepository extends JpaRepository<ProcessPart, Integer> {


    @Query("select distinct p.part from ProcessPart p where p.process.project.id = :projectId")
    List<Part> findDistinctPartsBy(Integer projectId);

    @Query("select p from ProcessPart p where p.part.id = :partId")
    List<ProcessPart> findProcessPartsBy(Integer partId);

    @Query("select p from ProcessPart p where p.process.id = :processId order by p.part.id")
    List<ProcessPart> findProcessIdBy(Integer processId);

}