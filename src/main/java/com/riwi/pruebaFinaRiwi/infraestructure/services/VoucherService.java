package com.riwi.pruebaFinaRiwi.infraestructure.services;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VouchersResponse;
import com.riwi.pruebaFinaRiwi.domain.Repositories.VoucherRepository;
import com.riwi.pruebaFinaRiwi.domain.entities.Voucher;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IVoucherService;
import com.riwi.pruebaFinaRiwi.infraestructure.helpers.mappers.VoucherMapper;
import com.riwi.pruebaFinaRiwi.utils.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoucherService implements IVoucherService{
    
    @Autowired
    private VoucherMapper voucherMapper;
    
    @Autowired
    private VoucherRepository voucherRepository;
    
    @Override
    public VouchersResponse create(VoucherRequest request) {
        
        Voucher voucher = this.voucherMapper.requestToEntity(request);
        return this.voucherMapper.entityToResponse(this.voucherRepository.save(voucher));
    }

    @Override
    public VouchersResponse update(String id, VoucherRequest request) {

        Voucher voucher = this.find(id);
        voucher.getRedeemeVouchers().forEach(redeemedVoucher -> {
            if (redeemedVoucher.getId().equals(id)) {
                JOptionPane.showMessageDialog(null, "¡It is not possible to modify this voucher!");
                return; 
            }
        });

        voucher = this.voucherMapper.requestToEntity(request);
        voucher.setId(id);
        return this.voucherMapper.entityToResponse(this.voucherRepository.save(voucher));
        
    }

    @Override
    public void delete(String id) {

        Voucher voucher = this.find(id);
        voucher.getRedeemeVouchers().forEach(redeemedVoucher -> {
            if (redeemedVoucher.getId().equals(id)) {
                voucher.setStatus(false);
                this.voucherRepository.save(voucher);
            }

            this.voucherRepository.delete(this.find(id));
        });
    }

    @Override
    public Page<VouchersResponse> findAll(int page, int size) {
        if (page <= 0) {
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page, size);
        return this.voucherRepository.findAll(pagination).map(this.voucherMapper::entityToResponse);
    }

    @Override
    public VouchersResponse findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    private Voucher find(String id) {
        return this.voucherRepository.findById(id)
        .orElseThrow(()-> new BadRequestException("Don't have voucher with id " + id));
    }

    public List<Voucher> findAllList() {
        
        return this.voucherRepository.findAll();
    }

    @Override
    public Page<VouchersResponse> getByStatus(boolean status, int page, int size) {
        if (page <= 0) {
            page = 0;
        }

        Pageable pageable = PageRequest.of(page, size);
        return this.voucherRepository.findAllByStatus(status, pageable).map(this.voucherMapper::entityToResponse);
        
    }
    
}