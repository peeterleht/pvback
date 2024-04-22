package com.valiit.pvback.business.company;

import com.valiit.pvback.business.company.dto.CompanyUserInfo;
import com.valiit.pvback.business.company.dto.UserAddToCompany;
import com.valiit.pvback.domain.company.companyuser.CompanyUser;
import com.valiit.pvback.domain.company.companyuser.CompanyUserMapper;
import com.valiit.pvback.domain.company.companyuser.CompanyUserRepository;
import com.valiit.pvback.domain.user.User;
import com.valiit.pvback.domain.user.UserMapper;
import com.valiit.pvback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CompanyService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CompanyUserRepository companyUserRepository;
private final CompanyUserMapper companyUserMapper;

    public List<UserAddToCompany> findUsersBySearchCriteria(String email) {
        List<User> users = userRepository.findUsersByEmailContains(email);
        return userMapper.toUserAddToCompany(users);
    }

    public List<CompanyUserInfo> findUsersByCompanyId(Integer companyId) {
        List<CompanyUser> companyUsers = companyUserRepository.findByCompany_Id(companyId);
        return companyUserMapper.toCompanyUserInfos(companyUsers);
    }
}
