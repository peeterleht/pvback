package com.valiit.pvback.business.company;

import com.valiit.pvback.business.company.dto.CompanyUserInfo;
import com.valiit.pvback.business.company.dto.CompanyUserRequest;
import com.valiit.pvback.business.company.dto.NewCompanyUserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/company/find-user-by-email")
    public List<NewCompanyUserInfo> getUsersBySearchCriteria(@RequestParam String email) {
        return companyService.getUsersBySearchCriteria(email);
    }

    @GetMapping("/company/users")
    @Operation(summary = "Kindla firma kasutajate päring companyId kaudu",
            description = "Päringu tulemus: proovi osa pealkiri, text ja nuppu nimetus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<CompanyUserInfo> findUsersByCompanyId(@RequestParam Integer companyId){
       return companyService.findUsersByCompanyId(companyId);
    }

    @PostMapping("/new/company/user/")
    public void addUserToCompany(@RequestBody CompanyUserRequest request){
        companyService.addUserToCompany(request);
    }

//    @PostMapping("/company-user")
//    public void addCompanyUser(@RequestBody @Valid)
}
