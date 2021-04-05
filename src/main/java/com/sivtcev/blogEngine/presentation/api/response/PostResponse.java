package com.sivtcev.blogEngine.presentation.api.response;

import com.sivtcev.blogEngine.presentation.api.response.Dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PostResponse {

    private long count;
    private List<PostDto> posts;
}
