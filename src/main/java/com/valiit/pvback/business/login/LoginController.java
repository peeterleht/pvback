package com.valiit.pvback.business.login;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    // todo: raja kaardistus HTTP  meetod (GET, POST, jne) ja URL
    // todo: meetodi nimi
    // todo:
    // todo: mida sisse ootab
    // todo: l6puks tekib mingi objekt mingist klassist (loginResponse, mida see meetod tagastab) aga alguses progedes void meetod
    // todo: actionit siin ei tee
    // todo: samanimelised meetodid

    @GetMapping("/login")
    public void login(@RequestParam String email, @RequestParam String password) {
        loginService.login(email,password);
    }
}
