package com.paws.devocean.dto;

import lombok.Builder;

@Builder
public record ProjectResponse(
        String title,
        String thumbnail,
        Long project_id
){}
