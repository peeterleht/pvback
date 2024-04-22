package com.valiit.pvback.business.register;

import com.valiit.pvback.business.user.dto.ExtendedUserRequest;
import com.valiit.pvback.business.user.dto.UserRequest;
import com.valiit.pvback.domain.company.Company;
import com.valiit.pvback.domain.company.CompanyRepository;
import com.valiit.pvback.domain.company.companyuser.CompanyUser;
import com.valiit.pvback.domain.company.companyuser.CompanyUserRepository;
import com.valiit.pvback.domain.company.subscriptiontype.SubscriptionType;
import com.valiit.pvback.domain.company.subscriptiontype.SubscriptionTypeRepository;
import com.valiit.pvback.domain.project.projectrole.ProjectRole;
import com.valiit.pvback.domain.project.projectrole.ProjectRoleRepository;
import com.valiit.pvback.domain.user.User;
import com.valiit.pvback.domain.user.UserMapper;
import com.valiit.pvback.domain.user.UserRepository;
import com.valiit.pvback.domain.user.role.Role;
import com.valiit.pvback.domain.user.role.RoleRepository;
import com.valiit.pvback.util.StringConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.valiit.pvback.business.ProjectRole.PROJECT_MANAGER;

@Service
@AllArgsConstructor
public class RegisterService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final SubscriptionTypeRepository subscriptionTypeRepository;
    private final CompanyRepository companyRepository;
    private final ProjectRoleRepository projectRoleRepository;
    private final CompanyUserRepository companyUserRepository;

    public void registerUser(UserRequest request) {
        createAndSaveUser(request);
    }

    public void registerCompanyAdmin(ExtendedUserRequest request) {
        User user = createAndSaveUser(request);
        Company company = createAndSaveCompany(request);
        createAndSaveCompanyUserAsAdmin(company, user);
    }

    private User createAndSaveUser(UserRequest request) {
        Role role = roleRepository.getReferenceById(request.getRoleId());
        User user = userMapper.toUser(request);
        user.setRole(role);
        userRepository.save(user);
        return user;
    }

    private Company createAndSaveCompany(ExtendedUserRequest request) {
        SubscriptionType subscriptionType = subscriptionTypeRepository.getReferenceById(request.getSubscriptionTypeId());
        Company company = new Company();
        company.setSubscriptionType(subscriptionType);
        company.setName(request.getCompanyName());
        if (hasLogo(request.getLogo())) {
            company.setLogo(StringConverter.stringToBytes(request.getLogo()));
        }
        companyRepository.save(company);
        return company;
    }

    private void createAndSaveCompanyUserAsAdmin(Company company, User user) {
        ProjectRole projectRole = projectRoleRepository.getReferenceById(PROJECT_MANAGER);
        CompanyUser companyUser = new CompanyUser();
        companyUser.setCompany(company);
        companyUser.setUser(user);
        companyUser.setProjectRole(projectRole);
        companyUser.setIsCompanyAdmin(true);
        companyUserRepository.save(companyUser);
    }


    private static boolean hasLogo(String logo) {
        return !logo.isEmpty();
    }

}
