package com.valiit.pvback.business.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.valiit.pvback.domain.user.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCompanyUserInfo implements Serializable {
    private Integer userId;
    private String email;
    private String name;
}