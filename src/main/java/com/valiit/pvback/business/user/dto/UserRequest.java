package com.valiit.pvback.business.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable {
    @NotNull
    private Integer roleId;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String username;
}
