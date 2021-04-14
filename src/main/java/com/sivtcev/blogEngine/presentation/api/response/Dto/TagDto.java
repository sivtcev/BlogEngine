package com.sivtcev.blogEngine.presentation.api.response.Dto;

import com.sivtcev.blogEngine.domain.models.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagDto {

    private String name;
    private double weight;
}
