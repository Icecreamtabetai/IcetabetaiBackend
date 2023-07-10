package com.example.icetabetaiBackend.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NonNull
@Getter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;
    @Column
    private String accountId;
    @Column
    private String password;

    @Builder
    public User(String email, String accountId, String password) {
        this.email = email;
        this.accountId = accountId;
        this.password = password;
    }

}
