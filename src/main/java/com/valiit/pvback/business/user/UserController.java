package com.valiit.pvback.business.user;


import com.valiit.pvback.business.user.dto.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController{
    private final UserService userService;


//    @GetMapping("/users/email/{email}")
//    public List<UserInfo> findUsersByEmail(@PathVariable String email){
//        return userService.findUsersByEmail(email);
//    }
}
