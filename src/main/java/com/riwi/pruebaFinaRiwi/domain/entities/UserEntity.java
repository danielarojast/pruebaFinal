package com.riwi.pruebaFinaRiwi.domain.entities;

import java.util.List;

import com.riwi.pruebaFinaRiwi.api.dto.response.VoucherRedeemedResponse;

import jakarta.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "users")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private String id;
    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,length = 50)
    private String lastName;
    @Column(nullable = false,length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String password;


    @OneToMany(mappedBy = "userEntity", orphanRemoval = false, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<RedeemedVoucher> redeemeVouchers;
}