package com.kwonkim.blog.like;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private int post_id;

    @Column(nullable = false)
    private boolean isDelete;

}
