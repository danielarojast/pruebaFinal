package com.riwi.pruebaFinaRiwi.domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.pruebaFinaRiwi.domain.entities.RedeemedVoucher;

@Repository
public interface RedemmerVoucherRepository extends JpaRepository<RedeemedVoucher, String> {
    
}
