package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM posts WHERE is_active=true and moderation_status='ACCEPTED' " +
            "and time <= NOW() ORDER BY time", nativeQuery = true)
    List<Post> findAllByIsActiveAndModerationStatusOrderByTimeAsc(Pageable pageable);

    @Query(value = "SELECT * FROM posts WHERE is_active=true and moderation_status='ACCEPTED' " +
            "and time <= NOW() ORDER BY time DESC ", nativeQuery = true)
    List<Post> findAllByIsActiveAndModerationStatusOrderByTimeDesc(Pageable pageable);

    @Query(value = "SELECT * FROM posts p WHERE is_active=true and moderation_status='ACCEPTED' " +
            " and time <= NOW() ORDER BY (SELECT COUNT(*) FROM post_comments pc WHERE pc.id = p.id) DESC",
            nativeQuery = true)
    List<Post> findAllByIsActiveAndModerationStatusOrderByPostComments(Pageable pageable);

    @Query(value = "SELECT * FROM posts p WHERE is_active=true and moderation_status='ACCEPTED' " +
            "and time <= NOW() ORDER BY (SELECT COUNT(*) FROM post_votes pc WHERE pc.id = p.id and pc.value = 1) DESC",
            nativeQuery = true)
    List<Post> findAllByIsActiveAndModerationStatusOrderByPostVotes(Pageable pageable);
}
