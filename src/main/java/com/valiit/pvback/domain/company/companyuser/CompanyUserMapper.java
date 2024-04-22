package com.valiit.pvback.domain.company.companyuser;

import com.valiit.pvback.business.company.dto.CompanyUserInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyUserMapper {
    CompanyUser toEntity(CompanyUserInfo companyUserInfo);

    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "user.email", target = "userEmail")
    @Mapping(source = "projectRole.name", target = "projectRoleName")
    @Mapping(source = "user.status", target = "userStatus")
    CompanyUserInfo toCompanyUserInfo(CompanyUser companyUser);

    List<CompanyUserInfo> toCompanyUserInfos(List<CompanyUser> companyUsers);

}