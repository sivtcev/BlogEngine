package com.sivtcev.blogEngine.presentation.api.response;

import com.sivtcev.blogEngine.presentation.api.response.Dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TagResponse {

    private List<TagDto> tags;
}
