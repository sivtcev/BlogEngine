package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.presentation.api.response.AuthResponse;

public interface AuthService {

    AuthResponse getAuthStatus();
}
