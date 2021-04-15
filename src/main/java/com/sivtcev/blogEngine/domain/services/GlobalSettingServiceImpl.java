package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.dao.repositories.GlobalSettingRepository;
import com.sivtcev.blogEngine.domain.models.GlobalSetting;
import com.sivtcev.blogEngine.domain.models.enums.GlobalSettingsValues;
import com.sivtcev.blogEngine.presentation.api.response.GlobalSettingsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GlobalSettingServiceImpl implements GlobalSettingService {

    private final GlobalSettingRepository globalSettingRepository;

    @Override
    public GlobalSettingsResponse getGlobalSettings() {
        boolean multiUserMode = false;
        boolean postPreModeration = false;
        boolean statisticIsPublic = false;

        List<GlobalSetting> globalSettingList = globalSettingRepository.findAll();

        for (GlobalSetting setting : globalSettingList) {
            if (setting.getCode().equals(GlobalSettingsValues.MULTIUSER_MODE)) {
                multiUserMode = setting.getValue();
            }

            if (setting.getCode().equals(GlobalSettingsValues.POST_PRE_MODERATION)) {
                postPreModeration = setting.getValue();
            }

            if (setting.getCode().equals(GlobalSettingsValues.STATISTICS_IS_PUBLIC)) {
                statisticIsPublic = setting.getValue();
            }

        }

        return new GlobalSettingsResponse(multiUserMode, postPreModeration, statisticIsPublic);
    }
}
