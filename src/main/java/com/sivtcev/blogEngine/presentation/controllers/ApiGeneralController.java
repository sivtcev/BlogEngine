package com.sivtcev.blogEngine.presentation.controllers;

import com.sivtcev.blogEngine.domain.services.GlobalSettingService;
import com.sivtcev.blogEngine.presentation.api.response.InitResponse;
import com.sivtcev.blogEngine.presentation.api.response.GlobalSettingsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApiGeneralController {

    private final GlobalSettingService globalSettingService;
    private final InitResponse initResponse;

    /**
     * @return information about blog (title, subtitle, phone, e-mail, copyright, copyright form) for site footer
     * Authorisation is not required
     */
    @GetMapping("/api/init")
    private InitResponse init(){
        return  initResponse;
    }

    /**
     * @return global settings from table global_settings. If parameter is YES - return true, if NO - return false
     * Authorisation is not required
     */
    @GetMapping("api/settings")
    private GlobalSettingsResponse SettingsResponse(){
        return globalSettingService.getGlobalSettings();
    }


}
