package com.valiit.pvback.business.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.valiit.pvback.domain.company.companyuser.CompanyUser}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyUserInfo implements Serializable {
    private Integer userId;
    private String userEmail;
    private String userName;
    private String userStatus;
    private String hoursStatus;
    private String projectRoleName;
}