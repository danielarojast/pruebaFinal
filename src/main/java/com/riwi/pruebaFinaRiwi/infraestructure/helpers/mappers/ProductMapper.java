package com.riwi.pruebaFinaRiwi.infraestructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.pruebaFinaRiwi.api.dto.requests.ProductRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.ProductResponse;
import com.riwi.pruebaFinaRiwi.domain.entities.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    
    ProductResponse entityToResponse(Product product);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vouchers", ignore = true)
    Product requestToEntity(ProductRequest productrequest);
}
