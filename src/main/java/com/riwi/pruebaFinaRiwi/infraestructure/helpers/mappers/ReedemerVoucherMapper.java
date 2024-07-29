package com.riwi.pruebaFinaRiwi.infraestructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRedeemedRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VoucherRedeemedResponse;
import com.riwi.pruebaFinaRiwi.domain.entities.RedeemeVoucher;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReedemerVoucherMapper {

    
    /*EntityToResponse */
    VoucherRedeemedResponse entityToResponse(RedeemeVoucher redeemeVoucher);
    
    /*RequestToEntity */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "redemptionDate", ignore = true)
    @Mapping(target = "userEntity.id", source = "userId")
    @Mapping(target = "voucher.id", source = "voucherId")
     RedeemeVoucher requestToEntity(VoucherRedeemedRequest voucherRedeemedRequest);
}
