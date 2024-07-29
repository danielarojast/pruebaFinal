package com.riwi.pruebaFinaRiwi.domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.pruebaFinaRiwi.domain.entities.RedeemeVoucher;

@Repository
public interface RedemmerVoucherRepository extends JpaRepository<RedeemeVoucher, String> {
    
}
