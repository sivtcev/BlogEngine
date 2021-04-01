package com.sivtcev.blogEngine.presentation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApiAuthController {

    @GetMapping("/api/auth/check")
    private void getAuthorizationStatus(){}

    @GetMapping("/api/auth/captcha")
    private void getCaptcha(){}

    @PostMapping("/api/auth/register")
    private void registerUser(){}

    @PostMapping("/api/auth/login")
    private void userLogin(){}

    @PostMapping("/api/auth/restore")
    private void restorePassword(){}

    @PostMapping("/api/auth/password")
    private void changePassword(){}

    @GetMapping("/api/auth/logout")
    private void userLogout(){}

}
