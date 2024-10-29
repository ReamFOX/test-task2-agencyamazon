package com.amazonagency.restapi.controller;

import com.amazonagency.restapi.dto.user.login.UserLoginRequestDto;
import com.amazonagency.restapi.dto.user.login.UserLoginResponseDto;
import com.amazonagency.restapi.dto.user.registration.RegisterUserRequestDto;
import com.amazonagency.restapi.dto.user.registration.RegisterUserResponseDto;
import com.amazonagency.restapi.security.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterUserResponseDto register(@RequestBody @Valid RegisterUserRequestDto requestDto) {
        return authService.register(requestDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authService.authenticate(requestDto);
    }
}
