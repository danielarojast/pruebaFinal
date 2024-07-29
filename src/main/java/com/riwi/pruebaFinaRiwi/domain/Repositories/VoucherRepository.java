package com.riwi.pruebaFinaRiwi.domain.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.pruebaFinaRiwi.domain.entities.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, String> {
    Page<Voucher> findAllByStatus(boolean status, Pageable pageable);
}
