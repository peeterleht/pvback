package com.valiit.pvback.domain.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class UserDto implements Serializable {
    Integer id;
    Integer roleId;
    String roleRole;
    @NotNull
    Integer password;
    @NotNull
    @Size(max = 255)
    String email;
}