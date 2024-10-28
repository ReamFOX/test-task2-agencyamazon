package com.amazonagency.restapi.dto.user.registration;

import com.amazonagency.restapi.lib.FieldMatch;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@FieldMatch(first = "password", second = "repeatPassword", message = "Passwords must match")
public final class RegisterUserRequestDto {
    @NotBlank
    @Size(min = 3, message = "Username must be at least 3 characters long")
    private String username;
    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    private String repeatPassword;
}
