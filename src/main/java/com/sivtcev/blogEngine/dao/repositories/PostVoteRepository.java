package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.PostVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostVoteRepository extends JpaRepository<PostVote, Long> {
}
