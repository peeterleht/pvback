package com.valiit.pvback.business.register;

import com.valiit.pvback.business.user.dto.ExtendedUserRequest;
import com.valiit.pvback.business.user.dto.UserRequest;
import com.valiit.pvback.domain.company.subscriptiontype.SubscriptionType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RegisterController {

    private RegisterService registerService;

    // todo: registerCompany()
    // todo: registerCompanyAdmin()

    @PostMapping("/register/company/user")
    @Operation(summary = "Uue tavakasutaja loomine",
            description = "Kande tulemus: andmebaasi lisatakse uus süsteemi kasutaja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public void registerCompanyUser(@RequestBody @Valid UserRequest request){
        registerService.registerUser(request);
    }

    @PostMapping("/register/company/admin")
    @Operation(summary = "Uue firma admini kasutaja ja firma loomine",
            description = "Kande tulemus: andmebaasi lisatakse uus süsteemi kasutaja, firma kasutaja ja firma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public void registerCompanyAdmin(@RequestBody @Valid ExtendedUserRequest request){
        registerService.registerCompanyAdmin(request);
    }

    @GetMapping("/subscriptionTypes")
    @Operation(summary = "Kõigi tellimustüüpide päring",
            description = "Päringu tulemus: tellimustüüpite id, nimi ja tier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<SubscriptionType> getSubscriptionTypes() {
        return registerService.getSubscriptionTypes();
    }
}
