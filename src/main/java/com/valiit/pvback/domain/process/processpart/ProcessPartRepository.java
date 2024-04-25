package com.valiit.pvback.domain.process.processpart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcessPartRepository extends JpaRepository<ProcessPart, Integer> {

}