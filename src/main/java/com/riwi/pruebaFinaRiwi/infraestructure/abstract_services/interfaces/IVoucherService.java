package com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VouchersResponse;

public interface IVoucherService extends CrudService<VoucherRequest, VouchersResponse, String> {
    public VouchersResponse findById(String id);
}
