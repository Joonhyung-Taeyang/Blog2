package com.kwonkim.blog.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id; // 데이터베이스 내에서 고유 식별을 위한 id - 기본 키

    @Column(nullable = false, unique = true)
    private String username; // 로그인 시 사용자가 사용하는 아이디

    @Column(nullable = false)
    private String password; // 로그인 시 사용자가 사용하는 비밀번호 - 해시로 암호화되어 저장

    @Column(nullable = false, unique = true)
    private String email; // 사용자의 이메일

    @Column(nullable = false, unique = true)
    private String nickname; // 사용자의 닉네임
}
