package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.presentation.api.response.TagResponse;

public interface TagService {

    TagResponse getAllTags();

    TagResponse getTagWithQuery(String query);
}
