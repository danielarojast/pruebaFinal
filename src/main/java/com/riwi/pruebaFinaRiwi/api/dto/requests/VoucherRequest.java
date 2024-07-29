package com.riwi.pruebaFinaRiwi.api.dto.requests;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoucherRequest {
    
    @NotBlank(message = "the description field is required")
    @Length(max = 150, message = "the description field must be less than 150 characters")
    private String description;

    @NotNull(message = "the discount field is required")
    private Double discount;

    @NotBlank(message = "the expirationDate field is required")
    private LocalDateTime expirationDate;

    @NotNull(message = "the status field is required")
    private Boolean status;

    private String productId;

}
