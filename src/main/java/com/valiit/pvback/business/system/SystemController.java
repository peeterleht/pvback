package com.valiit.pvback.business.system;

import com.valiit.pvback.business.system.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class SystemController {
    private SystemService systemService;

    @GetMapping("/system")
    public SystemInfo findSystemData(){
        return systemService.getSystemInfo();
    }
    @GetMapping("/sysadvert")
    public List<SysAdvertInfo> findSysAdvertData(){
        return systemService.getSysAdvertInfo();
    }
    @GetMapping("/sysfeedback")
    public List<SysFeedbackInfo> findSysFeedbackData(){
        return systemService.getSysFeedbackInfo();
    }
    @GetMapping("/syspaymenttier")
    public List<SysPaymentTierInfo> findPaymentTierData(){
        return systemService.getSysPaymentTierInfo();
    }
    @GetMapping("/sysprojectexample")
    public List<SysProjectExampleInfo> findSysProjectExampleData(){
        return systemService.getSysProjectExampleInfo();
    }
    @GetMapping("/systryout")
    public SysTryOutInfo findSysTryOutData(){
        return systemService.getSysTryOutInfo();
    }
}
