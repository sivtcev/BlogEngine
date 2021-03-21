package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;



@DataJpaTest
@DisplayName("Post repository must:")
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @DisplayName("find post by id")
    public void findById() {
        Post post = entityManager.find(Post.class, 1L);
        assertThat(post).isNotNull();
    }

    @Test
    @DisplayName("find all posts")
    public void findAll(){
        int actualCount = postRepository.findAll().size();
        assertEquals("finding posts equals 3", 3, actualCount);
    }
}
