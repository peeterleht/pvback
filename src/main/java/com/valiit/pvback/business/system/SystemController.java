package com.valiit.pvback.business.system;

import com.valiit.pvback.business.system.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class SystemController {
    private SystemService systemService;

    @GetMapping("/system")
    @Operation(summary = "Põhiandmete päring",
            description = "Päringu tulemus: app logo, nimi ja moto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public SystemInfo findSystemData(){
        return systemService.getSystemInfo();
    }
    @PutMapping("/system")
    @Operation(summary = "Muudab põhiandmeid",
            description = "Salvestab: app logo, nimi ja moto")
    public void updateSystemData(@RequestBody @Valid SystemInfo systemInfo) {
        systemService.updateSystemData(systemInfo);
    }

    @GetMapping("/system/advert")
    @Operation(summary = "Reklaami osa päring",
            description = "Päringu tulemus: reklaami massiiv text, pilt, pool ja staatus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<SysAdvertInfo> findSysAdvertData(){
        return systemService.getSysAdvertInfo();
    }
    @GetMapping("/system/feedback")
    @Operation(summary = "Tagasiside osa päring",
            description = "Päringu tulemus: tagaside massiiv nimi ja text")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<SysFeedbackInfo> findSysFeedbackData(){
        return systemService.getSysFeedbackInfo();
    }
    @GetMapping("/system/paymenttier")
    @Operation(summary = "Tellimuse osa päring",
            description = "Päringu tulemus: tellimuse variantide massiiv tellimuse nimetus, maksumuse, ja kirjeldus 8. real")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<SysPaymentTierInfo> findPaymentTierData(){
        return systemService.getSysPaymentTierInfo();
    }
    @GetMapping("/system/projectexample")
    @Operation(summary = "Projektide näidiste osa päring",
            description = "Päringu tulemus: projektide näidiste massiiv projekti ID, nimi ja text")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<SysProjectExampleInfo> findSysProjectExampleData(){
        return systemService.getSysProjectExampleInfo();
    }
    @GetMapping("/system/tryout")
    @Operation(summary = "Proovi osa päring",
            description = "Päringu tulemus: proovi osa pealkiri, text ja nuppu nimetus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public SysTryOutInfo findSysTryOutData(){
        return systemService.getSysTryOutInfo();
    }
}
