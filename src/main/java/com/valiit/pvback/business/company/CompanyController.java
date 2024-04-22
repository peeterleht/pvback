package com.valiit.pvback.business.company;

import com.valiit.pvback.business.company.dto.CompanyUserInfo;
import com.valiit.pvback.business.company.dto.UserAddToCompany;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/company/find-user-by-email")
    public List<UserAddToCompany> findUsersBySearchCriteria(@RequestParam String email) {
        return companyService.findUsersBySearchCriteria(email);
    }

    @GetMapping("/company/users")
    public List<CompanyUserInfo> findUsersByCompanyId(@RequestParam Integer companyId){
       return companyService.findUsersByCompanyId(companyId);
    }

//    @PostMapping("/company-user")
//    public void addCompanyUser(@RequestBody @Valid)
}
