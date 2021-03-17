package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.GlobalSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalSettingRepository extends JpaRepository<GlobalSetting, Long> {
}
