package com.valiit.pvback.domain.company.companyuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyUserRepository extends JpaRepository<CompanyUser, Integer> {

    @Query("select c from CompanyUser c where c.user.id = :userId")
    CompanyUser findCompanyUser(Integer userId);

    @Query("select c from CompanyUser c where c.company.id = :companyId")
    List<CompanyUser> findCompanyUsersBy(Integer companyId);

    @Query("select (count(c) > 0) from CompanyUser c where c.user.id = :userId")
    boolean userExistsBy(Integer userId);

}