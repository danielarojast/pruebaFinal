package com.riwi.pruebaFinaRiwi.api.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoucherRedeemedRequest {

    @NotBlank(message = "the userId field is required")
    private String userId;

    @NotBlank(message = "the vaucherId field is required")
    private String vaucherId;

}
