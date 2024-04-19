package com.valiit.pvback.business.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedUserRequest extends UserRequest {
    @NotNull
    private Integer subscriptionTypeId;
    @NotNull
    @Size(max = 255)
    private String companyname;
    private String logo;
}
