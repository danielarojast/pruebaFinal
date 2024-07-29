package com.riwi.pruebaFinaRiwi.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaucherRedeemedResponse {
    
    private String userId;
    private String vaucherId;
    private LocalDateTime redeemptionDate;
}
