
package com.valiit.pvback.domain.user;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.login.dto.LoginResponse;
import com.valiit.pvback.business.user.dto.ExtendedUserRequest;
import com.valiit.pvback.business.user.dto.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);



    @Mapping(source = "password",target = "password")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "userName",target = "name")
    @Mapping(constant = Status.ACTIVE, target = "status")
    User toUser(UserRequest extendedUserRequest);
}
