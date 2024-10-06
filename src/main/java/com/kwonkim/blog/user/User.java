package com.kwonkim.blog.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

/*    @Column(name = "user_uuid", columnDefinition = "BINARY(16)", nullable = false, unique = true)
    private UUID uuid;*/

    @Column(nullable = false, unique = true)
    private String username; // ID

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname; // 이름

    @Column(nullable = false)
    private  boolean isDelete;
}
