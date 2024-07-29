package com.riwi.pruebaFinaRiwi.api.dto.requests.create;

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
public class ProductRequestCreate {

    @NotBlank(message = "the name field is required")
    private String name;

    @NotNull(message = "the price field is required")
    private Double price;
    
}
