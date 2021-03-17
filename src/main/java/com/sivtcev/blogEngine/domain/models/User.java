package com.sivtcev.blogEngine.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 *
 */

@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_moderator", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean isModerator;

    @Column(name = "reg_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime regTime;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR", length = 255)
    private String name;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR", length = 255)
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR", length = 255)
    private String password;

    @Column(name = "code", nullable = true, columnDefinition = "VARCHAR", length = 255)
    private String code;

    @Column(name = "photo", nullable = true, columnDefinition = "TEXT")
    private String photo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Post> postList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<PostComment> postCommentList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<PostVote> postVoteList;

}
