package com.sivtcev.blogEngine.presentation.controllers;

import com.sivtcev.blogEngine.domain.services.GlobalSettingService;
import com.sivtcev.blogEngine.presentation.api.response.InitResponse;
import com.sivtcev.blogEngine.presentation.api.response.SettingsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApiGeneralController {

    private final GlobalSettingService globalSettingService;
    private final InitResponse initResponse;

    @GetMapping("/api/init")
    private InitResponse init(){
        return  initResponse;
    }

    @GetMapping("api/settings")
    private SettingsResponse SettingsResponse(){
        return globalSettingService.getGlobalSettings();
    }
}
