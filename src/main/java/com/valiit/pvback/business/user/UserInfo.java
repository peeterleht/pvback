package com.valiit.pvback.business.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.valiit.pvback.domain.user.User}
 */
@Value
public class UserInfo implements Serializable {
    String roleName;
    @NotNull
    @Size(max = 255)
    String userEmail;
    @NotNull
    @Size(max = 255)
    String userName;
    @NotNull
    String userStatus;
}