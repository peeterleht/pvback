package com.valiit.pvback.domain.user;

import com.valiit.pvback.business.login.dto.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.role", target = "roleName")
    LoginResponse toLoginResponse(User user);
}