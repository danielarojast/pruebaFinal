package com.riwi.pruebaFinaRiwi.infraestructure.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRedeemedRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VoucherRedeemedResponse;
import com.riwi.pruebaFinaRiwi.domain.Repositories.RedemmedVoucherRepository;
import com.riwi.pruebaFinaRiwi.domain.entities.RedeemedVoucher;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IRedeemedVoucherService;
import com.riwi.pruebaFinaRiwi.infraestructure.helpers.mappers.ReedemerVoucherMapper;
import com.riwi.pruebaFinaRiwi.utils.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RedeemedVoucherService implements IRedeemedVoucherService {

    private final RedemmedVoucherRepository redeemedVoucherRepository;
    private final ReedemerVoucherMapper redeemedVoucherMapper;
    
    @Override
    public VoucherRedeemedResponse create(VoucherRedeemedRequest request) {
        RedeemedVoucher redeemedVoucher = this.redeemedVoucherMapper.requestToEntity(request);
        return this.redeemedVoucherMapper.entityToResponse(redeemedVoucherRepository.save(redeemedVoucher));
    }

    @Override
    public VoucherRedeemedResponse update(String id, VoucherRedeemedRequest request) {
        RedeemedVoucher redeemedVoucher = this.find(id);
        redeemedVoucher = this.redeemedVoucherMapper.requestToEntity(request);
        return this.redeemedVoucherMapper.entityToResponse(redeemedVoucherRepository.save(redeemedVoucher));
    }

    @Override
    public void delete(String id) {
        RedeemedVoucher redeemedVoucher = this.find(id);
        redeemedVoucherRepository.delete(redeemedVoucher);
    }

    @Override
    public Page<VoucherRedeemedResponse> findAll(int page, int size) {
        if (page < 0)
            page = 0;

        PageRequest pageRequest = PageRequest.of(page, size);
        return this.redeemedVoucherRepository.findAll(pageRequest).map(this.redeemedVoucherMapper::entityToResponse);
    }

    @Override
    public VoucherRedeemedResponse findById(String id) {
        return this.redeemedVoucherMapper.entityToResponse(this.find(id));
    }

    private RedeemedVoucher find(String id) {
        return this.redeemedVoucherRepository.findById(id).orElseThrow(() -> new BadRequestException("No records with the supplied ID"));
    }
    
}
