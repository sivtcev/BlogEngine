package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.presentation.api.response.SettingsResponse;
import org.springframework.stereotype.Service;

@Service
public class GlobalSettingService {

    public SettingsResponse getGlobalSettings(){
        SettingsResponse settingsResponse = new SettingsResponse();
        settingsResponse.setMultiUserMode(true);
        settingsResponse.setPostPremoderation(false);
        settingsResponse.setPostPremoderation(true);
        return settingsResponse;
    }
}
