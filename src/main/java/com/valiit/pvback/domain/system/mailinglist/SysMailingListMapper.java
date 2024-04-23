package com.valiit.pvback.domain.system.mailinglist;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.business.system.dto.SysMailingListInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysMailingListMapper {

    @Mapping(source = "sysMailingListEmail",target = "email")
    @Mapping(constant = Status.ACTIVE,target = "status")
    SysMailingList toMailingList(SysMailingListInfo sysMailingListInfo);
}