package com.riwi.pruebaFinaRiwi.api.dto.requests;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityRequest {
    
    @NotBlank(message = "the name field is required")
    @Length(max = 100, message = "the name field must be less than 100 characters")
    private String name;

    @NotBlank(message = "the lastName field is required")
    @Length(max = 100, message = "the lastName field must be less than 100 characters")
    private String lastName;
    
    @Length(max = 100, message = "the email field must be less than 100 characters")
    @NotBlank(message = "the email field is required")
    private String email;
    
    @NotBlank(message = "the password field is required")
    private String password;
}
