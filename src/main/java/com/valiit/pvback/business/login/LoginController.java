package com.valiit.pvback.business.login;

import com.valiit.pvback.business.login.dto.LoginResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @GetMapping("/login")
    public LoginResponse login(@RequestParam String email, @RequestParam String password) {
        return loginService.login(email, password);
    }

    // todo: raja kaardistus HTTP  meetod (GET, POST, jne) ja URL
    // todo: meetodi nimi
    // todo: mida sisse ootab
    // todo: l6puks tekib mingi objekt mingist klassist (loginResponse, mida see meetod tagastab) aga alguses progedes void meetod
    // todo: actionit siin ei tee
    // todo: samanimelised meetodid
}
