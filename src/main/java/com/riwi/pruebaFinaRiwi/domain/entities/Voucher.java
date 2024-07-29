package com.riwi.pruebaFinaRiwi.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.riwi.pruebaFinaRiwi.api.dto.response.VoucherRedeemedResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "vouchers")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false,precision = 2, scale = 2)
    private BigDecimal discount;
    @Column(nullable = false)
    private LocalDateTime expirationDate;
    @Column(nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "voucher", orphanRemoval = false, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<RedeemedVoucher> redeemeVouchers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId",referencedColumnName = "id")
    private Product product;
    
}
