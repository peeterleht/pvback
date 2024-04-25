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

    @GetMapping("/company/users/search")
    @Operation(summary = "Kasutaja otsimine meili järgi (leiab kõik kasutajad, kelle meil sisaldab otsingu inputti)",
            description = "Päringu tulemus: Tagastatakse kõikide sobivate kasutajate meil, nimi, userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<NewCompanyUserInfo> getUsersBySearchCriteria(@RequestParam String userInput) {
        return companyService.getUsersBySearchCriteria(userInput);
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
    @Operation(summary = "Uue firma kasutaja lisamine",
            description = "Kande tulemus: Kasutajale lisatakse firma ja projektiroll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public void addUserToCompany(@RequestBody CompanyUserRequest request){
        companyService.addUserToCompany(request);
    }

//    @PostMapping("/company-user")
//    public void addCompanyUser(@RequestBody @Valid)
}
