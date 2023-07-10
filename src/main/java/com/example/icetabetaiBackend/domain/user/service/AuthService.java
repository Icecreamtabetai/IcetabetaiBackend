package com.example.icetabetaiBackend.domain.user.service;

import com.example.icetabetaiBackend.domain.user.controller.dto.request.LoginRequest;
import com.example.icetabetaiBackend.domain.user.controller.dto.request.SignupRequest;
import com.example.icetabetaiBackend.domain.user.controller.dto.response.TokenResponse;
import com.example.icetabetaiBackend.domain.user.entity.User;
import com.example.icetabetaiBackend.domain.user.exception.AlreadyExistException;
import com.example.icetabetaiBackend.domain.user.exception.PasswordNotMatchesException;
import com.example.icetabetaiBackend.domain.user.exception.UserNotFoundException;
import com.example.icetabetaiBackend.domain.user.repository.UserRepository;
import com.example.icetabetaiBackend.global.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider tokenProvider;

    public void Signup(SignupRequest request) {
        if (userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw new AlreadyExistException();
        }
        else if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new AlreadyExistException();
        }

        userRepository.save(User.builder()
                        .email(request.getEmail())
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build());
        }

    public TokenResponse Login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
           throw new PasswordNotMatchesException();
        }

        String accessToken = tokenProvider.createAccessToken(request.getEmail());
        String refreshToken = tokenProvider.createRefreshToken(request.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

    }

}
