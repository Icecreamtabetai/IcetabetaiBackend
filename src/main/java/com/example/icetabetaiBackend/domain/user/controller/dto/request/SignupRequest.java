package com.example.icetabetaiBackend.domain.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class SignupRequest {

    private String email;
    private String accountId;
    private String password;

}
