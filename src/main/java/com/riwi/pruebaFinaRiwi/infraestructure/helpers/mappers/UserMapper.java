package com.riwi.pruebaFinaRiwi.infraestructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.pruebaFinaRiwi.api.dto.requests.UserEntityRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.UserEntityResponse;
import com.riwi.pruebaFinaRiwi.domain.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserEntityResponse entityToResponse(UserEntity userEntity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "redeemeVouchers", ignore = true)
    UserEntity requestToEntity(UserEntityRequest userEntityRequest);
}
