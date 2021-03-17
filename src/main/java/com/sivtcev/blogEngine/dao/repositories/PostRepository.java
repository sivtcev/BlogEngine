package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
