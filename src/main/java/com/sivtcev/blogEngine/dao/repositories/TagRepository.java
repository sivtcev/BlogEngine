package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
