package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.Post;
import com.sivtcev.blogEngine.domain.models.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNull;


@DataJpaTest
@DisplayName("Tag repository must:")
public class TagRepositoryTest {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @DisplayName("find tag by id")
    public void findById() {
        Tag tag = entityManager.find(Tag.class, 1L);
        assertThat(tag).isNotNull();
    }

    @Test
    @DisplayName("find all tags")
    public void findAll(){
        int actualCount = tagRepository.findAll().size();
        assertEquals("finding tags equals 3", 3, actualCount);
    }

    @Test
    @DisplayName("adding new tag")
    public void addNew(){
        Set<Post> posts = new HashSet<>();
        Tag savedTag = new Tag(4L, "new", posts);
        tagRepository.save(savedTag);
        Tag receivedTag = entityManager.find(Tag.class, 4L);
        assertThat(receivedTag).isNotNull().isEqualTo(savedTag);
    }

    @Test
    @DisplayName("delete tag")
    void deleteOne(){
        tagRepository.deleteById(3L);
        assertNull("deleted tag not found", entityManager.find(Tag.class, 3L));
    }
}
