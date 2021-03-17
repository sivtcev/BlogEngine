package com.sivtcev.blogEngine.dao.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@DisplayName("Captcha code repository must:")
class CaptchaCodeRepositoryTest {

    @Autowired
    CaptchaCodeRepository captchaCodeRepository;

    @Test
    @DisplayName("save captcha code")
    public void saveCaptchaCodeTest() {

    }

}
