package com.sivtcev.blogEngine.domain.services;

import com.sivtcev.blogEngine.dao.repositories.PostRepository;
import com.sivtcev.blogEngine.dao.repositories.TagRepository;
import com.sivtcev.blogEngine.domain.models.Post;
import com.sivtcev.blogEngine.domain.models.Tag;
import com.sivtcev.blogEngine.domain.models.enums.ModerationStatus;
import com.sivtcev.blogEngine.presentation.api.response.Dto.TagDto;
import com.sivtcev.blogEngine.presentation.api.response.TagResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final PostRepository postRepository;


    @Override
    public TagResponse getAllTags() {
        List<Tag> tagList = tagRepository.findAll();
        return new TagResponse(calculateTagWeight(tagList));
    }

    @Override
    public TagResponse getTagWithQuery(String query) {
        if (query.isEmpty()){
            return getAllTags();
        }
        List<Tag> tagList = tagRepository.findByNameStartingWith(query);
        return new TagResponse(calculateTagWeight(tagList));
    }

    private List<TagDto> calculateTagWeight(List<Tag> tagList) {
        List<Post> postList = postRepository.findAll().stream()
                .filter(post -> post.getIsActive().equals(true))
                .filter(post -> post.getModerationStatus().equals(ModerationStatus.ACCEPTED))
                .filter(post -> post.getTime().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
        List<TagDto> unNormalizeTagDto = new ArrayList<>(tagList.size());

        for (Tag tag : tagList) {
            double tagPostsCount = postList.stream()
                    .filter(post -> post.getTagSet().contains(tag))
                    .count();
            double tagUnNormalizeWeight = tagPostsCount / postList.size();
            unNormalizeTagDto.add(new TagDto(tag.getName(), tagUnNormalizeWeight));
        }
        unNormalizeTagDto.sort(Comparator.comparing(TagDto::getWeight));
        double k = 1 / unNormalizeTagDto.get(0).getWeight();

        unNormalizeTagDto.get(0).setWeight(1D);
        return unNormalizeTagDto.stream()
                .skip(1)
                .peek(tagDto -> {
                    double normalizeWeight = tagDto.getWeight() * k;
                    tagDto.setWeight(normalizeWeight);
                })
                .collect(Collectors.toList());
    }
}
