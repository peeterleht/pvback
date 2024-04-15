package com.valiit.pvback.domain.company.companyuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyUserRepository extends JpaRepository<CompanyUser, Integer> {

    @Query("select c from CompanyUser c where c.user.id = :userId")
    CompanyUser findCompanyUser(Integer userId);
}