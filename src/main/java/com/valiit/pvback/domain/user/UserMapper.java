
package com.valiit.pvback.domain.user;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.login.dto.LoginResponse;
import com.valiit.pvback.business.user.UserInfo;
import com.valiit.pvback.business.user.UserInfoExtended;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "name",target = "userName")
    @Mapping(source = "role.name",target = "roleName")
    @Mapping(source = "email",target = "userEmail")
    @Mapping(source = "status",target = "userStatus")
    UserInfo toUserInfo(User user);

    List<UserInfo> toUserInfos(List<User> users);

    @Mapping(constant = Status.UNDEFINED,target = "role.name")
    @Mapping(source = "userPassword",target = "password")
    @Mapping(source = "userEmail",target = "email")
    @Mapping(source = "userName",target = "name")
    @Mapping(constant = Status.ACTIVE, target = "status")
    User toUser(UserInfoExtended userInfoExtended);
}
