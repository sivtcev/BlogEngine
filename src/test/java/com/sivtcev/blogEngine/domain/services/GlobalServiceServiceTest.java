package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.ServiceTestConfiguration;
import com.sivtcev.blogEngine.dao.repositories.GlobalSettingRepository;
import com.sivtcev.blogEngine.domain.models.GlobalSetting;
import com.sivtcev.blogEngine.domain.models.enums.GlobalSettingsValues;
import com.sivtcev.blogEngine.presentation.api.response.GlobalSettingsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@DisplayName("Global settings service class test:")
public class GlobalServiceServiceTest {

    @MockBean
    private GlobalSettingRepository globalSettingRepository;

    @Autowired
    private GlobalSettingService globalSettingService;

    @Test
    void getGlobalSettingsTest() {
        List<GlobalSetting> globalSettingList = new ArrayList<>();
        globalSettingList.add(new GlobalSetting(
                null,
                GlobalSettingsValues.MULTIUSER_MODE,
                GlobalSettingsValues.MULTIUSER_MODE.getName(),
                true
        ));
        globalSettingList.add(new GlobalSetting(
                null,
                GlobalSettingsValues.POST_PRE_MODERATION,
                GlobalSettingsValues.POST_PRE_MODERATION.getName(),
                false
        ));
        globalSettingList.add(new GlobalSetting(
                null,
                GlobalSettingsValues.STATISTICS_IS_PUBLIC,
                GlobalSettingsValues.STATISTICS_IS_PUBLIC.getName(),
                true
        ));
        Mockito.when(globalSettingRepository.findAll()).thenReturn(globalSettingList);

        GlobalSettingsResponse globalSettingsResponse = globalSettingService.getGlobalSettings();

        assertTrue("Multiuser mode true", globalSettingsResponse.isMultiUserMode());
        assertFalse("Premoderation mode true", globalSettingsResponse.isPostPremoderation());
        assertTrue("statistic is public mode true", globalSettingsResponse.isStatisticIsPublic());
    }
}
