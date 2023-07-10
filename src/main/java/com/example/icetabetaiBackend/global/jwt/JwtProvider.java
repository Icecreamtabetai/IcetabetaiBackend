package com.example.toyproject.global.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtProvider {

    @Value("${auth.jwt.secret}")
    private String secretKey;

    public String createAccessToken(String value) {
        return createToken(value, "access", 7200L); // 2시간
    }
    public String createRefreshToken(String value) {
        return createToken(value, "refresh", 172800L); // 2일
    }

    public String createToken(String email, String type, Long exp) {
        return Jwts.builder()
                .claim("type", type)
                .setIssuedAt(new Date()) // 생성일
                .setSubject(email) // 대상자
                .setExpiration(new Date(System.currentTimeMillis() + (exp * 1000L))) // 만료
                .signWith(SignatureAlgorithm.HS256, secretKey) // 사용할 알고리즘, 키 적용
                .compact(); // jwt 빌드
    }


}
