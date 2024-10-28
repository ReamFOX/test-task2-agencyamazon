package com.amazonagency.restapi.security;

import com.amazonagency.restapi.dto.user.login.UserLoginRequestDto;
import com.amazonagency.restapi.dto.user.login.UserLoginResponseDto;
import com.amazonagency.restapi.dto.user.registration.RegisterUserRequestDto;
import com.amazonagency.restapi.dto.user.registration.RegisterUserResponseDto;
import com.amazonagency.restapi.exception.RegistrationException;

public interface AuthService {
    RegisterUserResponseDto register(RegisterUserRequestDto requestDto)
            throws RegistrationException;

    UserLoginResponseDto authenticate(UserLoginRequestDto requestDto);
}
