package com.valiit.pvback.business.company.dto;

import jakarta.validation.constraints.NotNull;
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
public class CompanyUserRequest implements Serializable {
    @NotNull
    private Integer companyId;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer projectRoleId;
    @NotNull
    private Boolean isCompanyAdmin = false;
}