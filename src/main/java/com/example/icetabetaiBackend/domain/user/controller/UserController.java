package com.example.toyproject.domain.user.controller;

import com.example.toyproject.domain.user.controller.dto.request.LoginRequest;
import com.example.toyproject.domain.user.controller.dto.request.SignupRequest;
import com.example.toyproject.domain.user.controller.dto.response.TokenResponse;
import com.example.toyproject.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final AuthService authService;
    @PostMapping("/signup")
    public void AddUser(@RequestBody SignupRequest request) {
        authService.Signup(request);
    }
    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return authService.Login(request);
    }



}
