package com.paws.devocean.dto;

import lombok.Builder;

@Builder
public record ProjectDetailResponse(
        String title,
        String content
) {
}
