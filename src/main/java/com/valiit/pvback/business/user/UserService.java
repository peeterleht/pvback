package com.valiit.pvback.business.user;

import com.valiit.pvback.domain.user.User;
import com.valiit.pvback.domain.user.UserMapper;
import com.valiit.pvback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public List<UserInfo> getAllUsers() {
        List<User> users =userRepository.findAll();
        return userMapper.toUserInfos(users);

    }
}
