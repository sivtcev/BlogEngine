package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.CaptchaCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNull;


@DataJpaTest
@DisplayName("Captcha code repository must:")
class CaptchaCodeRepositoryTest {

    @Autowired
    CaptchaCodeRepository captchaCodeRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @DisplayName("find captcha code by id")
    public void findById() {
        CaptchaCode captchaCode = entityManager.find(CaptchaCode.class, 1L);
        assertThat(captchaCode).isNotNull();
    }

    @Test
    @DisplayName("find all captcha codes")
    public void findAll(){
        int actualCount = captchaCodeRepository.findAll().size();
        assertEquals("finding captcha codes equals 3", 3, actualCount);
    }

    @Test
    @DisplayName("adding new captcha code")
    public void addNew(){
        CaptchaCode savedCaptchaCode = new CaptchaCode(4L, LocalDateTime.now(), 4, 4);
        captchaCodeRepository.save(savedCaptchaCode);
        CaptchaCode receivedCaptchaCode = entityManager.find(CaptchaCode.class, 4L);
        assertThat(receivedCaptchaCode).isNotNull().isEqualTo(savedCaptchaCode);
    }

    @Test
    @DisplayName("delete captcha code")
    void deleteOne(){
        captchaCodeRepository.deleteById(3L);
        assertNull("deleted captcha code not found", entityManager.find(CaptchaCode.class, 3L));
    }
}
