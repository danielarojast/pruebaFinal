package com.riwi.pruebaFinaRiwi.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name = "vouchers")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false,precision = 2, scale = 2)
    private BigDecimal discount;
    @Column(nullable = false)
    private LocalDate expirationDate;
    @Column(nullable = false)
    private Boolean status;
}
