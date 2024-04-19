package com.valiit.pvback.business.company;

import com.valiit.pvback.domain.user.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.valiit.pvback.domain.user.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddToCompany implements Serializable {
    private Integer roleId;
    private String roleName;
    private String password;
    private String email;
    private String name;
    private String status;
}