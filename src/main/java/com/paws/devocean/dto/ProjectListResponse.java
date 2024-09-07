package com.paws.devocean.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ProjectListResponse (
    List<ProjectResponse> projects
){}

