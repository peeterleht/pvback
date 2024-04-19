
package com.valiit.pvback.domain.user;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.company.UserAddToCompany;
import com.valiit.pvback.business.login.dto.LoginResponse;
import com.valiit.pvback.business.user.dto.ExtendedUserRequest;
import com.valiit.pvback.business.user.dto.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);



    @Mapping(source = "password",target = "password")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "username",target = "name")
    @Mapping(constant = Status.ACTIVE, target = "status")
    User toUser(UserRequest extendedUserRequest);

    @Mapping(source = "roleName", target = "role.name")
    @Mapping(source = "roleId", target = "role.id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "roleName", target = "role")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "status", target = "status")
    User toUserGoCompany(UserAddToCompany userAddToCompany);

    List<UserAddToCompany> toUserAddToCompany(List<User> users);
}
