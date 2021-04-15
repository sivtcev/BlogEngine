package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.presentation.api.response.AuthResponse;
import com.sivtcev.blogEngine.presentation.api.response.Dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    @Override
    public AuthResponse getAuthStatus() {
        UserDto user = new UserDto(
                567L,
                "Dmitriy Petrov",
                "/avatar/ab/cd/ef/52461.jpg",
                "petrov@petroff.ru",
                true,
                56L,
                true);

        return new AuthResponse(true, user);
    }
}
