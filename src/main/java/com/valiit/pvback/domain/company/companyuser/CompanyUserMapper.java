package com.valiit.pvback.domain.company.companyuser;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.company.dto.CompanyUserInfo;
import com.valiit.pvback.business.company.dto.CompanyUserRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyUserMapper {

    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "projectRoleId", target = "projectRole.id")
    @Mapping(source = "isCompanyAdmin", target = "isCompanyAdmin")

    CompanyUser toCompanyUser(CompanyUserRequest companyUserRequest);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "user.email", target = "userEmail")
    @Mapping(source = "user.status", target = "userStatus", qualifiedByName = "toUserStatus")
    @Mapping(constant = "Ok", target = "hoursStatus")
    @Mapping(source = "projectRole.name", target = "projectRoleName")
    CompanyUserInfo toCompanyUserInfo(CompanyUser companyUser);

    List<CompanyUserInfo> toCompanyUserInfos(List<CompanyUser> companyUsers);

    @Named("toUserStatus")
    static String toUserStatus(String status) {
        if (Status.ACTIVE.equals(status)) {
            return "Aktiivne";
        } else {
            return "Deaktiveeritud";
        }
    }

}