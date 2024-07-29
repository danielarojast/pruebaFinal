package com.riwi.pruebaFinaRiwi.infraestructure.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRedeemedRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VoucherRedeemedResponse;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IRedeemeVoucherService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RedeemedVoucher implements IRedeemeVoucherService {@Override
    public VoucherRedeemedResponse create(VoucherRedeemedRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public VoucherRedeemedResponse update(String id, VoucherRedeemedRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<VoucherRedeemedResponse> findAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public VoucherRedeemedResponse findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
