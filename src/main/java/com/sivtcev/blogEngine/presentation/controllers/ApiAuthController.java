package com.sivtcev.blogEngine.presentation.controllers;

import com.sivtcev.blogEngine.domain.services.AuthService;
import com.sivtcev.blogEngine.presentation.api.response.AuthResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApiAuthController {

    private final AuthService authService;

    /**
     * @return information about the current authorized user, if he is authorized.
     * It should check whether the ID of the current session is saved in the list of authorized users.
     *
     * Authorisation is not required
     */
    @GetMapping("/api/auth/check")
    public ResponseEntity<AuthResponse> getAuthorizationStatus(){
        return ResponseEntity.ok(authService.getAuthStatus());
    }

    @GetMapping("/api/auth/captcha")
    public void getCaptcha(){}

    @PostMapping("/api/auth/register")
    public void registerUser(){}

    @PostMapping("/api/auth/login")
    public void userLogin(){}

    @PostMapping("/api/auth/restore")
    public void restorePassword(){}

    @PostMapping("/api/auth/password")
    public void changePassword(){}

    @GetMapping("/api/auth/logout")
    public void userLogout(){}

}
