package com.sivtcev.blogEngine.presentation.api.response.Dto;

import com.sivtcev.blogEngine.domain.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class PostDto {

    private long id;
    private long timestamp;
    private UserDto user;
    private String title;
    private String announce;
    private long likeCount;
    private long dislikeCount;
    private long commentCount;
    private long viewCount;

    public PostDto(Post post){
        this.id = post.getId();
        this.timestamp = post.getTime().toInstant(ZoneOffset.UTC).toEpochMilli();
        this.user = new UserDto(post.getUser());
        this.title = post.getTitle();
        //TODO: make announce realisation
        this.announce = post.getText();
        this.likeCount = post.getLikeCount();
        this.dislikeCount = post.getDisLikeCount();
        this.commentCount = post.getCommentCount();
        this.viewCount = post.getViewCount();
    }
}
