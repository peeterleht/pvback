package com.valiit.pvback.business.company;

import com.valiit.pvback.business.company.dto.CompanyUserInfo;
import com.valiit.pvback.business.company.dto.CompanyUserRequest;
import com.valiit.pvback.business.company.dto.NewCompanyUserInfo;
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

    public List<NewCompanyUserInfo> getUsersBySearchCriteria(String email) {
        List<User> users = userRepository.findUsersByContains(email);
        return userMapper.toNewCompanyUserInfos(users);
    }

    public List<CompanyUserInfo> findUsersByCompanyId(Integer companyId) {
        List<CompanyUser> companyUsers = companyUserRepository.findCompanyUsersBy(companyId);
        List<CompanyUserInfo> companyUserInfos = companyUserMapper.toCompanyUserInfos(companyUsers);
        // todo: for tsykli sees (companyUserInfos) arvutada valja iga useri kohta tema tundide staatus,
        // tulemuseks saad kirjutada mida iganes (tulemuseks string)
        return companyUserInfos;
    }

    public void addUserToCompany(CompanyUserRequest request) {
        CompanyUser companyUser = companyUserMapper.toCompanyUser(request);
        companyUserRepository.save(companyUser);
    }

}
