package com.sivtcev.blogEngine.presentation.api.response;

import com.sivtcev.blogEngine.presentation.api.response.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private boolean result;
    private UserDto user;
}
