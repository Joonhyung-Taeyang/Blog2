package com.kwonkim.blog.post;

import com.kwonkim.blog.comment.Comment;
import com.kwonkim.blog.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 기본으로 할당해주는 어노테이션
    @Column(name = "post_id")
    private Long id;

    @Column(name = "uuid", columnDefinition = "BINARY(16)", nullable = false, unique = true)
    private UUID post_uuid;

    @ManyToOne(fetch = FetchType.LAZY) // FetchType을 lazy로 두면 실제 객체를 사용하는 시점에 쿼리를 날린다.
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column(name = "post_content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post")
    private List<Comment> comment;

    @Column(name = "isDelete", nullable = false)
    protected boolean isDelete;
}
