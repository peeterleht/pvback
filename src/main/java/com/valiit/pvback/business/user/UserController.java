package com.valiit.pvback.business.user;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController{
    private final UserService userService;

    @GetMapping("/users")
    public List<UserInfo> viewUsers(){
        return userService.getAllUsers();
    }
}
