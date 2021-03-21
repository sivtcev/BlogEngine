package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.PostComment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;



@DataJpaTest
@DisplayName("Post comment repository must:")
public class PostCommentRepositoryTest {

    @Autowired
    PostCommentRepository postCommentRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @DisplayName("find post comment by id")
    public void findById() {
        PostComment postComment = entityManager.find(PostComment.class, 1L);
        assertThat(postComment).isNotNull();
    }

    @Test
    @DisplayName("find all post comments")
    public void findAll(){
        int actualCount = postCommentRepository.findAll().size();
        assertEquals("finding post comments equals 3", 3, actualCount);
    }
}
