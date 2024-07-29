package com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRedeemedRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VoucherRedeemedResponse;

public interface IRedeemedVoucherService extends CrudService<VoucherRedeemedRequest,VoucherRedeemedResponse,String> {
    public VoucherRedeemedResponse findById(String id);
}
