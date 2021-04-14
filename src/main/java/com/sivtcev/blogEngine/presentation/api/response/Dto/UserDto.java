package com.sivtcev.blogEngine.presentation.api.response.Dto;

import com.sivtcev.blogEngine.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserDto {

    private long id;
    private String name;
    private String photo;
    private String email;
    private boolean moderation;
    private long moderationCount;
    private boolean settings;


    public UserDto(long id, String name){
        this.id = id;
        this.name = name;
    }

    public UserDto(long id, String name, String photo, String email, boolean moderation, long moderationCount, boolean settings){
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.email = email;
        this.moderation = moderation;
        this.moderationCount = moderationCount;
        this.settings = settings;
    }

    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
