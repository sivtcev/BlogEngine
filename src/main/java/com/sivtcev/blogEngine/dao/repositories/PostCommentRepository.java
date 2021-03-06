package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
