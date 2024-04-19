package com.valiit.pvback.business.company;

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

//    @PostMapping("/company-user")
//    public void addCompanyUser(@RequestBody @Valid)
}
