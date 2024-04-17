package com.valiit.pvback.business.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull
    private Integer roleId;
    @NotNull
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;



}
