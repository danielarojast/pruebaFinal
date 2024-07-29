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
public class UserEntityRequestUpdate {
    
    @NotBlank(message = "the name field is required")
    private String name;

    @NotBlank(message = "the lastName field is required")
    private String lastName;

    @NotBlank(message = "the email field is required")
    private String email;

    @NotBlank(message = "the password field is required")
    private String password;
}
