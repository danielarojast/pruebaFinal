package com.riwi.pruebaFinaRiwi.infraestructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VouchersResponse;
import com.riwi.pruebaFinaRiwi.domain.entities.Voucher;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VoucherMapper {
    
    VouchersResponse entityToResponse(Voucher voucher);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "redeemeVouchers", ignore = true)
    @Mapping(target = "product.id", source = "productId")
    Voucher requestToEntity(VoucherRequest voucherRequest);
}
