package com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces;

import org.springframework.data.domain.Page;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VouchersResponse;

public interface IVoucherService extends CrudService<VoucherRequest, VouchersResponse, String> {
    public VouchersResponse findById(String id);
    Page<VouchersResponse> getByStatus(boolean status, int page, int size);
}
