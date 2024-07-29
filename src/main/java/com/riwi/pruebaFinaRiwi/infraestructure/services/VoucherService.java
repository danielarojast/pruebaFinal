package com.riwi.pruebaFinaRiwi.infraestructure.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VouchersResponse;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IVoucherService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoucherService implements IVoucherService{@Override
    public VouchersResponse create(VoucherRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public VouchersResponse update(String id, VoucherRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<VouchersResponse> findAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public VouchersResponse findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}