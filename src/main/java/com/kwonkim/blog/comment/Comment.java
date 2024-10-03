package com.kwonkim.blog.comment;

import com.kwonkim.blog.post.Post;
import com.kwonkim.blog.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 기본으로 할당해주는 어노테이션
    private Long id;

    @Column(name = "uuid", columnDefinition = "BINARY(16)", nullable = false, unique = true)
    private UUID comment_uuid;

    @ManyToOne(fetch = FetchType.LAZY) // FetchType을 lazy로 두면 실제 객체를 사용하는 시점에 쿼리를 날린다.
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "isDelete", nullable = false)
    protected boolean isDelete;

}
