package com.riwi.pruebaFinaRiwi.api.dto.requests.update;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestUpdate {
    
    @NotBlank(message = "the name field is required")
    private String name;

    @NotBlank(message = "the price field is required")
    private Double price;
}
