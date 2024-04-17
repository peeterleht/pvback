package com.valiit.pvback.business.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedUserRequest extends UserRequest {
    private String companyName;
    private Integer subscriptionTypeId;
    private String imageDate;
}
