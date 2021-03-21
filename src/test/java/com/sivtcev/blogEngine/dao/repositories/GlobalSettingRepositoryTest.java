package com.sivtcev.blogEngine.dao.repositories;

import com.sivtcev.blogEngine.domain.models.GlobalSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static com.sivtcev.blogEngine.domain.models.enums.GlobalSettingsValues.MULTIUSER_MODE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNull;


@DataJpaTest
@DisplayName("Global settings repository must:")
public class GlobalSettingRepositoryTest {

    @Autowired
    GlobalSettingRepository globalSettingRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @DisplayName("find global settings by id")
    public void findById() {
        GlobalSetting globalSetting = entityManager.find(GlobalSetting.class, 1L);
        assertThat(globalSetting).isNotNull();
    }

    @Test
    @DisplayName("find all global settings")
    public void findAll(){
        int actualCount = globalSettingRepository.findAll().size();
        assertEquals("finding global settings equals 3", 3, actualCount);
    }

    @Test
    @DisplayName("adding new global settings")
    public void addNew(){
        GlobalSetting savedGlobalSettings = new GlobalSetting(4L, MULTIUSER_MODE, MULTIUSER_MODE.getName(), true);
        globalSettingRepository.save(savedGlobalSettings);
        GlobalSetting receivedGlobalSettings = entityManager.find(GlobalSetting.class, 4L);
        assertThat(receivedGlobalSettings).isNotNull().isEqualTo(savedGlobalSettings);
    }

    @Test
    @DisplayName("delete global settings")
    void deleteOne(){
        globalSettingRepository.deleteById(3L);
        assertNull("deleted global setting not found", entityManager.find(GlobalSetting.class, 3L));
    }
}
