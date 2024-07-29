package com.riwi.pruebaFinaRiwi.domain.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "products")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private Double price;

    @OneToMany(mappedBy = "product", orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Voucher> vouchers;
}
