package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.presentation.api.response.Dto.TagDto;
import com.sivtcev.blogEngine.presentation.api.response.TagResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService{

    @Override
    public TagResponse getAllTags() {
        List<TagDto> tags = new ArrayList<>(4);
        tags.add(new TagDto("Java", 1D));
        tags.add(new TagDto("Spring", 0.56D));
        tags.add(new TagDto("Hibernate", 0.22D));
        tags.add(new TagDto("Hadoop", 0.17D));
        return new TagResponse(tags);
    }

    @Override
    public TagResponse getTagWithQuery(String query) {
        return null;
    }
}
