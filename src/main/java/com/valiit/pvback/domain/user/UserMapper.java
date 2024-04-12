package com.valiit.pvback.domain.user;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "roleRole", target = "role.role")
    @Mapping(source = "roleId", target = "role.id")
    User toEntity(UserDto userDto);

    @InheritInverseConfiguration(name = "toEntity")
    UserDto toDto(User user);

}