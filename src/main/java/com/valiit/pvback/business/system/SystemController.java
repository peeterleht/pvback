package com.valiit.pvback.business.system;

import com.valiit.pvback.business.system.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public SystemInfo findSystemData() {
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
    public List<SysAdvertInfo> findSysAdvert() {
        return systemService.getSysAdvertInfo();
    }

    @PutMapping("/system/advert")
    @Operation(summary = "Uuendab reklaami osa",
            description = "Salvestab: reklaami massiiv text, pilt, pool ja staatus")
    public void updateSysAdvert(@RequestBody @Valid SysAdvertInfo sysAdvertInfo) {
        systemService.updateSysAdvert(sysAdvertInfo);
    }

    @PostMapping("/system/advert")
    @Operation(summary = "Uus reklaami osa",
            description = "Salvestab: reklaami massiiv text, pilt, pool ja staatus")
    public void addSysAdvert(@RequestBody @Valid SysAdvertInfo sysAdvertInfo) {
        systemService.addSysAdvert(sysAdvertInfo);
    }

    @GetMapping("/system/feedback")
    @Operation(summary = "Tagasiside osa päring",
            description = "Päringu tulemus: tagaside massiiv nimi ja text")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<SysFeedbackInfo> findSysFeedback() {
        return systemService.getSysFeedbackInfo();
    }

    @PutMapping("/system/feedback")
    @Operation(summary = "Uuendab tagasiside osa",
            description = "Salvestab: tagaside massiiv nimi ja text")
    public void updateSysFeedback(@RequestBody @Valid SysFeedbackInfo sysFeedbackInfo) {
        systemService.updateSysFeedback(sysFeedbackInfo);
    }

    @PostMapping("/system/feedback/")
    @Operation(summary = "Uus tagasiside osa",
            description = "Salvestab: tagaside massiiv nimi ja text")
    public void addSysFeedback(@RequestBody @Valid SysFeedbackInfo sysFeedbackInfo) {
        systemService.addSysFeedback(sysFeedbackInfo);
    }

    @DeleteMapping("/system/feedback/{sysFeedbackId}")
    @Operation(summary = "Kustuta tagasiside osa",
            description = "Kustutab: tagaside massiiv nimi ja text")
    public void removeSysFeedback(@PathVariable Integer sysFeedbackId) {
        systemService.removeSysFeedback(sysFeedbackId);
    }

    @GetMapping("/system/paymenttier")
    @Operation(summary = "Tellimuse osa päring",
            description = "Päringu tulemus: tellimuse variantide massiiv tellimuse nimetus, maksumuse, ja kirjeldus 8. real")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<SysPaymentTierInfo> findPaymentTier() {
        return systemService.getSysPaymentTierInfo();
    }

    @PutMapping("/system/paymenttier")
    @Operation(summary = "Uuendab tellimuse osa",
            description = "Salvestab: tellimuse variantide massiiv tellimuse nimetus, maksumuse, ja kirjeldus 8. real")
    public void updatePaymentTier(@RequestBody @Valid SysPaymentTierInfo sysPaymentTierInfo) {
        systemService.updateSysPaymentTier(sysPaymentTierInfo);
    }

    @PostMapping("/system/paymenttier")
    @Operation(summary = "Uus tellimuse osa",
            description = "Salvestab: tellimuse variantide massiiv tellimuse nimetus, maksumuse, ja kirjeldus 8. real")
    public void addPaymentTier(@RequestBody @Valid SysPaymentTierInfo sysPaymentTierInfo) {
        systemService.addSysPaymentTier(sysPaymentTierInfo);
    }

    @DeleteMapping("/system/paymenttier/{sysPaymentTierId}")
    @Operation(summary = "Kustuta tellimuse osa",
            description = "Kustutab: tellimuse variantide massiiv tellimuse nimetus, maksumuse, ja kirjeldus 8. real")
    public void removePaymentTier(@PathVariable Integer sysPaymentTierId) {
        systemService.removeSysPaymentTier(sysPaymentTierId);
    }

    @GetMapping("/system/projectexample")
    @Operation(summary = "Projektide näidiste osa päring",
            description = "Päringu tulemus: projektide näidiste massiiv projekti ID, nimi ja text")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public List<SysProjectExampleInfo> findSysProjectExample() {
        return systemService.getSysProjectExampleInfo();
    }

    @PutMapping("/system/projectexample")
    @Operation(summary = "Uuendab projektide näidiste osa",
            description = "Salvestab: projektide näidiste massiiv projekti ID, nimi ja text")
    public void updateSysProjectExample(@RequestBody @Valid SysProjectExampleInfo sysProjectExampleInfo) {
        systemService.updateSysProjectExample(sysProjectExampleInfo);
    }

    @PostMapping("/system/projectexample")
    @Operation(summary = "Uus projektide näidiste osa",
            description = "Salvestab: projektide näidiste massiiv projekti ID, nimi ja text")
    public void addSysProjectExample(@RequestBody @Valid SysProjectExampleInfo sysProjectExampleInfo) {
        systemService.addSysProjectExample(sysProjectExampleInfo);
    }

    @DeleteMapping("/system/projectexample/{sysProjectExampleId}")
    @Operation(summary = "Kustuta projektide näidiste osa",
            description = "Kustutab: projektide näidiste massiiv projekti ID, nimi ja text")
    public void removeSysProjectExample(@PathVariable Integer sysProjectExampleId) {
        systemService.removeSysProjectExample(sysProjectExampleId);
    }

    @GetMapping("/system/tryout")
    @Operation(summary = "Proovi osa päring",
            description = "Päringu tulemus: proovi osa pealkiri, text ja nuppu nimetus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "andmed OK"),
    })
    public SysTryOutInfo findSysTryOut() {
        return systemService.getSysTryOutInfo();
    }

    @PutMapping("/system/tryout")
    @Operation(summary = "Uuendab proovi osa",
            description = "Salvestab: proovi osa pealkiri, text ja nuppu nimetus")
    public void updateSysTryOut(@RequestBody @Valid SysTryOutInfo sysTryOutInfo) {
        systemService.updateSysTryOut(sysTryOutInfo);
    }

    @PostMapping("/system/mailinglist")
    @Operation(summary = "Uus email",
            description = "Salvestab: uus email")
    public void addToSysMailingList(@RequestBody @Valid SysMailingListInfo sysMailingListInfo) {
        systemService.addToSysMailingList(sysMailingListInfo);
    }
}
