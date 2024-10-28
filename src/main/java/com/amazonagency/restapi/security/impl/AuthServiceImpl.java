package com.amazonagency.restapi.security.impl;

import com.amazonagency.restapi.dto.user.login.UserLoginRequestDto;
import com.amazonagency.restapi.dto.user.login.UserLoginResponseDto;
import com.amazonagency.restapi.dto.user.registration.RegisterUserRequestDto;
import com.amazonagency.restapi.dto.user.registration.RegisterUserResponseDto;
import com.amazonagency.restapi.exception.RegistrationException;
import com.amazonagency.restapi.model.User;
import com.amazonagency.restapi.repository.UserRepository;
import com.amazonagency.restapi.security.AuthService;
import com.amazonagency.restapi.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public RegisterUserResponseDto register(RegisterUserRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByUsername(requestDto.getUsername()).isPresent()) {
            throw new RegistrationException("User with username "
                    + requestDto.getUsername() + " already exist");
        }

        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        userRepository.save(user);

        RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
        responseDto.setUsername(user.getUsername());
        return responseDto;
    }

    @Override
    public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword())
        );
        String token = jwtUtil.generateToken(authentication.getName());
        return new UserLoginResponseDto(token);
    }
}
