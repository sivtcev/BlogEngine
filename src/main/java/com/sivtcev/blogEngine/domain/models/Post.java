package com.sivtcev.blogEngine.domain.models;

import com.sivtcev.blogEngine.domain.models.enums.ModerationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * <h1>Posts entity class</h1>
 * This class is entity of "posts" table
 * @author sivtcev
 * @version 0.1.1
 * @since 2021-03-17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name= "is_active", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "moderation_status", nullable = false, columnDefinition = "VARCHAR")
    private ModerationStatus moderationStatus;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "moderator_id", referencedColumnName = "id")
    private User moderator;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime time;

    @Column(name = "title", nullable = false, columnDefinition = "VARCHAR")
    private String title;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name = "view_count", nullable = false, columnDefinition = "INT")
    private Integer viewCount;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PostVote> postVoteList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "tag2post", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Tag> tagSet;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PostComment> postCommentList;

    public long getLikeCount(){
        return postVoteList.stream()
                .filter(postVote -> postVote.getValue() == 1)
                .count();
    }

    public long getDisLikeCount(){
        return postVoteList.stream()
                .filter(postVote -> postVote.getValue() == -1)
                .count();
    }

    public long getCommentCount(){
        return postCommentList.size();
    }
}
