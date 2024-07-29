package com.riwi.pruebaFinaRiwi.api.dto.requests.update;

import java.time.LocalDateTime;

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
public class VaucherRequestUpdate {
    
    @NotBlank(message = "the description field is required")
    private String description;

    @NotNull(message = "the discount field is required")
    private Double discount;
    
    private LocalDateTime expirationDate;

    @NotNull(message = "the status field is required")
    private Boolean status;

}
