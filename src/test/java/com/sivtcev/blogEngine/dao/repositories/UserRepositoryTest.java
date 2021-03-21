package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNull;


@DataJpaTest
@DisplayName("User repository must:")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @DisplayName("find user by id")
    public void findById() {
        User user = entityManager.find(User.class, 1L);
        assertThat(user).isNotNull();
    }

    @Test
    @DisplayName("find all users")
    public void findAll(){
        int actualCount = userRepository.findAll().size();
        assertEquals("finding users equals 3", 3, actualCount);
    }

    @Test
    @DisplayName("adding new user")
    public void addNew(){
        Set<Post> posts = new HashSet<>(0);
        Set<PostComment> postComments = new HashSet<>(0);
        Set<PostVote> postVotes = new HashSet<>(0);
        User savedUser = new User(4L, Boolean.TRUE, LocalDateTime.now(), "User", "Email", "Password", "Code", "Photo", posts, postComments, postVotes);
        userRepository.save(savedUser);
        User receivedUser = entityManager.find(User.class, 4L);
        assertThat(receivedUser).isNotNull().isEqualTo(savedUser);
    }
}
