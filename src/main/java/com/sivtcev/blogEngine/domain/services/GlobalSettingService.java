package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.presentation.api.response.GlobalSettingsResponse;
import org.springframework.stereotype.Service;

@Service
public class GlobalSettingService {

    public GlobalSettingsResponse getGlobalSettings(){
        GlobalSettingsResponse globalSettingsResponse = new GlobalSettingsResponse();
        globalSettingsResponse.setMultiUserMode(true);
        globalSettingsResponse.setPostPremoderation(false);
        globalSettingsResponse.setPostPremoderation(true);
        return globalSettingsResponse;
    }
}
