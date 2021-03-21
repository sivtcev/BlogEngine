package com.sivtcev.blogEngine.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <h1>Post vote entity class</h1>
 * This class is entity of "post_votes" table
 * @author sivtcev
 * @version 0.1.1
 * @since 2021-03-17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "post_votes")
public class PostVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false, referencedColumnName = "id")
    private Post post;

    @Column(name = "time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime time;

    @Column(name = "value", nullable = false, columnDefinition = "SMALLINT")
    private Integer value;
}
