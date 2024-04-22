package com.valiit.pvback.business.register;

import com.valiit.pvback.business.user.dto.ExtendedUserRequest;
import com.valiit.pvback.business.user.dto.UserRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {

    private RegisterService registerService;

    // todo: registerCompany()
    // todo: registerCompanyAdmin()

    @PostMapping("/register/company/user")
    public void registerCompanyUser(@RequestBody @Valid UserRequest request){
        registerService.registerUser(request);
    }

    @PostMapping("/register/company/admin")
    public void registerCompanyAdmin(@RequestBody @Valid ExtendedUserRequest request){
        registerService.registerCompanyAdmin(request);
    }

}
