package com.sivtcev.blogEngine.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * <h1>User entity class</h1>
 * This class is entity of "users" table
 * @author sivtcev
 * @version 0.1.1
 * @since 2021-03-17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_moderator", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean isModerator;

    @Column(name = "reg_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime regTime;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR")
    private String name;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR")
    private String password;

    @Column(name = "code", columnDefinition = "VARCHAR")
    private String code;

    @Column(name = "photo", columnDefinition = "TEXT")
    private String photo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Post> postList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<PostComment> postCommentList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<PostVote> postVoteList;

}
