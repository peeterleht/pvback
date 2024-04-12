package com.valiit.pvback.business.login.dto;

import com.valiit.pvback.domain.user.User;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class LoginResponse implements Serializable {
    Integer userId;
    String roleName;
}