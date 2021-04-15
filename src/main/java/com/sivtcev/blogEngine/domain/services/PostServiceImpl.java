package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.dao.repositories.PostRepository;
import com.sivtcev.blogEngine.presentation.api.response.Dto.PostDto;
import com.sivtcev.blogEngine.presentation.api.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostResponse getPosts(int offset, int limit, String mode) {
        List<PostDto> postsDtoList;
        Pageable pageable = getPageable(offset, limit);
        long count = postRepository.count();

        if (mode.equals("popular")) {
            postsDtoList = postRepository.findAllByIsActiveAndModerationStatusOrderByPostComments(pageable)
                    .stream()
                    .map(PostDto::new)
                    .collect(Collectors.toList());
            return new PostResponse(count, postsDtoList);
        }

        if (mode.equals("best")) {
            postsDtoList = postRepository.findAllByIsActiveAndModerationStatusOrderByPostVotes(pageable)
                    .stream()
                    .map(PostDto::new)
                    .collect(Collectors.toList());
            return new PostResponse(count, postsDtoList);
        }

        if (mode.equals("early")) {
            postsDtoList = postRepository.findAllByIsActiveAndModerationStatusOrderByTimeAsc(pageable)
                    .stream()
                    .map(PostDto::new)
                    .collect(Collectors.toList());
            return new PostResponse(count, postsDtoList);
        }

        // when mode recent and it's a default value
        postsDtoList = postRepository.findAllByIsActiveAndModerationStatusOrderByTimeDesc(pageable)
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
        return new PostResponse(count, postsDtoList);
    }

    private Pageable getPageable(int offset, int limit) {
        // TODO: check later is able to have zero limit.
        limit = limit == 0 ? 1 : limit;
        int page = (offset / limit);
        return PageRequest.of(page, limit);
    }
}
