package com.amazonagency.restapi.dto.user.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public final class UserLoginRequestDto {
    @NotBlank
    @Size(min = 3, message = "Username must be at least 3 characters long")
    private String username;
    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
