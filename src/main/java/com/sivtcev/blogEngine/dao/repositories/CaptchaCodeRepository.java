package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.CaptchaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptchaCodeRepository extends JpaRepository<CaptchaCode, Long> {
}
