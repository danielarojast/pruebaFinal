package com.riwi.pruebaFinaRiwi.api.dto.response;

import java.util.List;

import com.riwi.pruebaFinaRiwi.domain.entities.RedeemedVoucher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityResponse {
    
    private String name;
    private String lastName;
    private String email;
    private String password;

    private List<RedeemedVoucher> vaucherHistory; 

}

