package com.sivtcev.blogEngine.presentation.controllers;

import com.sivtcev.blogEngine.domain.services.GlobalSettingServiceImpl;
import com.sivtcev.blogEngine.domain.services.TagService;
import com.sivtcev.blogEngine.presentation.api.response.InitResponse;
import com.sivtcev.blogEngine.presentation.api.response.GlobalSettingsResponse;
import com.sivtcev.blogEngine.presentation.api.response.TagResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ApiGeneralController {

    private final GlobalSettingServiceImpl globalSettingService;
    private final InitResponse initResponse;
    private final TagService tagService;

    /**
     * @return information about blog (title, subtitle, phone, e-mail, copyright, copyright form) for site footer
     *
     * Authorisation is not required
     */
    @GetMapping("/api/init")
    public InitResponse init() {
        return initResponse;
    }

    /**
     * @return global settings from table global_settings. If parameter is YES - return true, if NO - return false
     *
     * Authorisation is not required
     */
    @GetMapping("/api/settings")
    public GlobalSettingsResponse settingsResponse() {
        return globalSettingService.getGlobalSettings();
    }

    @PutMapping("/api/settings")
    public void saveGlobalSettings() {
    }

    /**
     * @return list of tags
     * @param query returned list of tags starting with the string specified in the query parameter.
     * If it is not specified, all tags are output.
     *
     * Authorisation is not required
     */
    @GetMapping("/api/tag")
    public ResponseEntity<TagResponse> tagList(
            @RequestParam(name = "query", required = false) String query) {

        return ResponseEntity.ok(tagService.getAllTags());
    }

    @GetMapping("/api/calendar")
    public void getPostAmountByDate() {
    }

    @PostMapping("/api/image")
    public void uploadImage() {
    }

    @PostMapping("/api/comment")
    public void addPostComment() {
    }

    @PostMapping("/api/moderation")
    public void moderatePost() {
    }

    @PostMapping("/api/profile/my")
    public void editProfile() {
    }

    @GetMapping("/api/statistics/my")
    public void getCurrentUserStatistic() {
    }

    @GetMapping("/api/statistics/all")
    public void getAllStatistic() {
    }
}
