package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.PostVote;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@DataJpaTest
@DisplayName("Post vote repository must:")
public class PostVoteRepositoryTest {

    @Autowired
    PostVoteRepository postVoteRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @DisplayName("find post vote by id")
    public void findById() {
        PostVote postVote = entityManager.find(PostVote.class, 1L);
        assertThat(postVote).isNotNull();
    }

    @Test
    @DisplayName("find all post votes")
    public void findAll(){
        int actualCount = postVoteRepository.findAll().size();
        assertEquals("finding post votes equals 3", 3, actualCount);
    }
}
