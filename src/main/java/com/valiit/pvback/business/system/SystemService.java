package com.valiit.pvback.business.system;

import com.valiit.pvback.business.system.dto.*;
import com.valiit.pvback.domain.system.System;
import com.valiit.pvback.domain.system.SystemMapper;
import com.valiit.pvback.domain.system.SystemRepository;
import com.valiit.pvback.domain.system.advert.SysAdvert;
import com.valiit.pvback.domain.system.advert.SysAdvertMapper;
import com.valiit.pvback.domain.system.advert.SysAdvertRepository;
import com.valiit.pvback.domain.system.feedback.SysFeedback;
import com.valiit.pvback.domain.system.feedback.SysFeedbackMapper;
import com.valiit.pvback.domain.system.feedback.SysFeedbackRepository;
import com.valiit.pvback.domain.system.paymenttier.SysPaymentTier;
import com.valiit.pvback.domain.system.paymenttier.SysPaymentTierMapper;
import com.valiit.pvback.domain.system.paymenttier.SysPaymentTierRepository;
import com.valiit.pvback.domain.system.projectexample.SysProjectExample;
import com.valiit.pvback.domain.system.projectexample.SysProjectExampleMapper;
import com.valiit.pvback.domain.system.projectexample.SysProjectExampleRepository;
import com.valiit.pvback.domain.system.tryout.SysTryOut;
import com.valiit.pvback.domain.system.tryout.SysTryOutMapper;
import com.valiit.pvback.domain.system.tryout.SysTryOutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SystemService {

    private final SystemRepository systemRepository;
    private final SysAdvertRepository sysAdvertRepository;
    private final SysFeedbackRepository sysFeedbackRepository;
    private final SysPaymentTierRepository sysPaymentTierRepository;
    private final SysProjectExampleRepository sysProjectExampleRepository;
    private final SysTryOutRepository sysTryOutRepository;

    private final SystemMapper systemMapper;
    private final SysAdvertMapper sysAdvertMapper;
    private final SysFeedbackMapper sysFeedbackMapper;
    private final SysPaymentTierMapper sysPaymentTierMapper;
    private final SysProjectExampleMapper sysProjectExampleMapper;
    private final SysTryOutMapper sysTryOutMapper;

    public SystemInfo getSystemInfo() {
        System systemData = systemRepository.findById(1).get();
        return systemMapper.toSystemInfo(systemData);
    }
    public List<SysAdvertInfo> getSysAdvertInfo() {
        List<SysAdvert> sysAdverts = sysAdvertRepository.findAll();
        return sysAdvertMapper.toSysAdvertInfos(sysAdverts);
    }
    public List<SysFeedbackInfo> getSysFeedbackInfo() {
        List<SysFeedback> sysFeedbacks = sysFeedbackRepository.findAll();
        return sysFeedbackMapper.toSysFeedbackInfos(sysFeedbacks);
    }
    public List<SysPaymentTierInfo> getSysPaymentTierInfo() {
        List<SysPaymentTier> sysPaymentTiers = sysPaymentTierRepository.findAll();
        return sysPaymentTierMapper.toSysPaymentTierInfos(sysPaymentTiers);
    }
    public List<SysProjectExampleInfo> getSysProjectExampleInfo() {
        List<SysProjectExample> sysProjectExamples = sysProjectExampleRepository.findAll();
        return sysProjectExampleMapper.toSysProjectExampleInfos(sysProjectExamples);
    }
    public SysTryOutInfo getSysTryOutInfo() {
        SysTryOut sysTryOut = sysTryOutRepository.getReferenceById(1);
        return sysTryOutMapper.toSysTryOutInfo(sysTryOut);
    }
}
