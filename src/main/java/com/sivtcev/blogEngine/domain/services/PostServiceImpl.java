package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.presentation.api.response.Dto.PostDto;
import com.sivtcev.blogEngine.presentation.api.response.Dto.UserDto;
import com.sivtcev.blogEngine.presentation.api.response.PostResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Override
    public PostResponse getPosts() {
        long count = 390L;
        List<PostDto> postDtoList = new ArrayList<>(1);
        UserDto user = new UserDto(88L, "Dmitriy Petrov");
        PostDto post = new PostDto(
                345L,
                1592338706L,
                user,
                "Post title",
                "Announce text of post without HTML tags",
                36L,
                3L,
                15L,
                55L);
        postDtoList.add(post);
        return new PostResponse(390L, postDtoList);
    }
}
