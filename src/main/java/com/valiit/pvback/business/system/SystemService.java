package com.valiit.pvback.business.system;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.system.dto.*;
import com.valiit.pvback.domain.company.subscriptiontype.SubscriptionType;
import com.valiit.pvback.domain.company.subscriptiontype.SubscriptionTypeRepository;
import com.valiit.pvback.domain.system.System;
import com.valiit.pvback.domain.system.SystemMapper;
import com.valiit.pvback.domain.system.SystemRepository;
import com.valiit.pvback.domain.system.advert.SysAdvert;
import com.valiit.pvback.domain.system.advert.SysAdvertMapper;
import com.valiit.pvback.domain.system.advert.SysAdvertRepository;
import com.valiit.pvback.domain.system.feedback.SysFeedback;
import com.valiit.pvback.domain.system.feedback.SysFeedbackMapper;
import com.valiit.pvback.domain.system.feedback.SysFeedbackRepository;
import com.valiit.pvback.domain.system.mailinglist.SysMailingList;
import com.valiit.pvback.domain.system.mailinglist.SysMailingListMapper;
import com.valiit.pvback.domain.system.mailinglist.SysMailingListRepository;
import com.valiit.pvback.domain.system.paymenttier.SysPaymentTier;
import com.valiit.pvback.domain.system.paymenttier.SysPaymentTierMapper;
import com.valiit.pvback.domain.system.paymenttier.SysPaymentTierRepository;
import com.valiit.pvback.domain.system.projectexample.SysProjectExample;
import com.valiit.pvback.domain.system.projectexample.SysProjectExampleMapper;
import com.valiit.pvback.domain.system.projectexample.SysProjectExampleRepository;
import com.valiit.pvback.domain.system.tryout.SysTryOut;
import com.valiit.pvback.domain.system.tryout.SysTryOutMapper;
import com.valiit.pvback.domain.system.tryout.SysTryOutRepository;
import com.valiit.pvback.infrastructure.validation.ValidationService;
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
    private final SubscriptionTypeRepository subscriptionTypeRepository;
    private final SysMailingListRepository sysMailingListRepository;

    private final SystemMapper systemMapper;
    private final SysAdvertMapper sysAdvertMapper;
    private final SysFeedbackMapper sysFeedbackMapper;
    private final SysPaymentTierMapper sysPaymentTierMapper;
    private final SysProjectExampleMapper sysProjectExampleMapper;
    private final SysTryOutMapper sysTryOutMapper;
    private final SysMailingListMapper sysMailingListMapper;

    public SystemInfo getSystemInfo() {
        System systemData = systemRepository.findById(1).get();
        return systemMapper.toSystemInfo(systemData);
    }

    public void updateSystemData(SystemInfo systemInfo) {
        System systemData = systemRepository.findById(1).get();
        systemMapper.updateSystemData(systemInfo, systemData);
        systemRepository.save(systemData);
    }

    public List<SysAdvertInfo> getSysAdvertInfo() {
        List<SysAdvert> sysAdverts = sysAdvertRepository.findAll();
        return sysAdvertMapper.toSysAdvertInfos(sysAdverts);
    }

    public void updateSysAdvert(SysAdvertInfo sysAdvertInfo) {
        SysAdvert sysAdvert = sysAdvertRepository.findById(sysAdvertInfo.getSysAdvertId()).get();
        sysAdvertMapper.updateSysAdvertInfo(sysAdvertInfo, sysAdvert);
        sysAdvertRepository.save(sysAdvert);
    }

    public void addSysAdvert(SysAdvertInfo sysAdvertInfo) {
        SysAdvert sysAdvert = sysAdvertMapper.toSysAdvert(sysAdvertInfo);
        sysAdvertRepository.save(sysAdvert);
    }

    public List<SysFeedbackInfo> getSysFeedbackInfo() {
        List<SysFeedback> sysFeedbacks = sysFeedbackRepository.findAll();
        return sysFeedbackMapper.toSysFeedbackInfos(sysFeedbacks);
    }

    public void updateSysFeedback(SysFeedbackInfo sysFeedbackInfo) {
        SysFeedback sysFeedback = sysFeedbackRepository.findById(sysFeedbackInfo.getSysFeedbackId()).get();
        sysFeedbackMapper.updateSysFeedbackInfo(sysFeedbackInfo, sysFeedback);
        sysFeedbackRepository.save(sysFeedback);
    }

    public void addSysFeedback(SysFeedbackInfo sysFeedbackInfo) {
        SysFeedback sysFeedback = sysFeedbackMapper.toSysFeedback(sysFeedbackInfo);
        sysFeedbackRepository.save(sysFeedback);
    }

    public void removeSysFeedback(Integer sysFeedbackId) {
        SysFeedback sysFeedback = sysFeedbackRepository.findById(sysFeedbackId).get();
        sysFeedbackRepository.delete(sysFeedback);
    }

    public List<SysPaymentTierInfo> getSysPaymentTierInfo() {
        List<SysPaymentTier> sysPaymentTiers = sysPaymentTierRepository.findAll();
        return sysPaymentTierMapper.toSysPaymentTierInfos(sysPaymentTiers);
    }

    public void updateSysPaymentTier(SysPaymentTierInfo sysPaymentTierInfo) {
        SysPaymentTier sysPaymentTier = sysPaymentTierRepository.findById(sysPaymentTierInfo.getSysPaymentTierId()).get();
        sysPaymentTierMapper.updateSysPaymentTierInfo(sysPaymentTierInfo, sysPaymentTier);
        sysPaymentTierRepository.save(sysPaymentTier);
    }

    public void addSysPaymentTier(SysPaymentTierInfo sysPaymentTierInfo) {
        SubscriptionType subscriptionType = addSubscriptionType(sysPaymentTierInfo);
        SysPaymentTier sysPaymentTier = sysPaymentTierMapper.toSysPaymentTier(sysPaymentTierInfo);
        sysPaymentTier.setSubscriptionType(subscriptionType);
        sysPaymentTierRepository.save(sysPaymentTier);
    }

    public void removeSysPaymentTier(Integer sysPaymentTierId) {
        SysPaymentTier sysPaymentTier = sysPaymentTierRepository.findById(sysPaymentTierId).get();
        sysPaymentTierRepository.delete(sysPaymentTier);
    }

    public List<SysProjectExampleInfo> getSysProjectExampleInfo() {
        List<SysProjectExample> sysProjectExamples = sysProjectExampleRepository.findAll();
        return sysProjectExampleMapper.toSysProjectExampleInfos(sysProjectExamples);
    }

    public void updateSysProjectExample(SysProjectExampleInfo sysProjectExampleInfo) {
        SysProjectExample sysProjectExample = sysProjectExampleRepository.findById(sysProjectExampleInfo.getSysProjectExampleId()).get();
        sysProjectExampleMapper.updateSysProjectExampleInfo(sysProjectExampleInfo, sysProjectExample);
        sysProjectExampleRepository.save(sysProjectExample);
    }

    public void addSysProjectExample(SysProjectExampleInfo sysProjectExampleInfo) {
        SysProjectExample sysProjectExample = sysProjectExampleMapper.toSysProjectExample(sysProjectExampleInfo);
        sysProjectExampleRepository.save(sysProjectExample);
    }

    public SysTryOutInfo getSysTryOutInfo() {
        SysTryOut sysTryOut = sysTryOutRepository.findById(1).get();
        return sysTryOutMapper.toSysTryOutInfo(sysTryOut);
    }

    public void removeSysProjectExample(Integer sysProjectExampleId) {
        SysProjectExample sysProjectExample = sysProjectExampleRepository.findById(sysProjectExampleId).get();
        sysProjectExampleRepository.delete(sysProjectExample);
    }

    public void updateSysTryOut(SysTryOutInfo sysTryOutInfo) {
        SysTryOut sysTryOut = sysTryOutRepository.findById(1).get();
        sysTryOutMapper.updateSysTryOutInfo(sysTryOutInfo, sysTryOut);
        sysTryOutRepository.save(sysTryOut);
    }

    public void addToSysMailingList(SysMailingListInfo sysMailingListInfo) {
        SysMailingList sysMailingList = sysMailingListMapper.toMailingList(sysMailingListInfo);
        sysMailingListRepository.save(sysMailingList);
    }

    private SubscriptionType addSubscriptionType(SysPaymentTierInfo sysPaymentTierInfo) {
        SubscriptionType subscriptionType;
        subscriptionType = new SubscriptionType();
        subscriptionType.setName(sysPaymentTierInfo.getSysPaymentTierSubscriptionTypeName());
        subscriptionTypeRepository.save(subscriptionType);
        return subscriptionType;
    }
}
