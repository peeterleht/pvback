package com.valiit.pvback.domain.process.part;

import com.valiit.pvback.business.project.dto.ProjectUserInfo;
import com.valiit.pvback.business.projectoverview.dto.PartInfo;
import com.valiit.pvback.business.projectoverview.dto.ProcessPartInfo;
import com.valiit.pvback.domain.process.part.Part;
import com.valiit.pvback.domain.project.projectuser.ProjectUser;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PartMapper {
    @Mapping(source = "id", target = "partId")
    @Mapping(source = "volume", target = "volume")
    @Mapping(source = "name", target = "partName")
//    @Mapping(source = "endDeadline", target = "deadlineWeek")
    PartInfo toPartInfo(Part part);

    List<PartInfo> toPartInfos(List<Part> parts);
}