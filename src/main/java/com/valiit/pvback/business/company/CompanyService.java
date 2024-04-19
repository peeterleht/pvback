package com.valiit.pvback.business.company;

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


    public List<UserAddToCompany> findUsersBySearchCriteria(String email) {
        List<User> users = userRepository.findUsersByEmailContains(email);
        return userMapper.toUserAddToCompany(users);
    }
}
