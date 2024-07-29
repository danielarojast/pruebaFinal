package com.riwi.pruebaFinaRiwi.api.dto.response;

import java.time.LocalDateTime;

import com.riwi.pruebaFinaRiwi.domain.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VouchersResponse {
    
    private String id;
    private String description;
    private Double discount;
    private LocalDateTime expirationDate;
    private Boolean status;
    private Product product; 
}
