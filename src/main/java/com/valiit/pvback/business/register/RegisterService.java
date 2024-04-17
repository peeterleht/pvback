package com.valiit.pvback.business.register;

import com.valiit.pvback.business.UserRole;
import com.valiit.pvback.business.user.dto.ExtendedUserRequest;
import com.valiit.pvback.business.user.dto.UserRequest;
import com.valiit.pvback.domain.user.User;
import com.valiit.pvback.domain.user.UserMapper;
import com.valiit.pvback.domain.user.UserRepository;
import com.valiit.pvback.domain.user.role.Role;
import com.valiit.pvback.domain.user.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.valiit.pvback.business.UserRole.ROLE_COMPANY_ADMIN;
import static com.valiit.pvback.business.UserRole.ROLE_COMPANY_USER;

@Service
@AllArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    public void registerUser(UserRequest request) {
        Role role = roleRepository.getReferenceById(request.getRoleId());
        User user = userMapper.toUser(request);
        user.setRole(role);
        userRepository.save(user);
    }

    public void registerCompanyAdmin(ExtendedUserRequest request) {

    }
}
