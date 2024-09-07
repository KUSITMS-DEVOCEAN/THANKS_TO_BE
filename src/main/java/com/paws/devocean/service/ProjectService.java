package com.paws.devocean.service;

import com.paws.devocean.dto.ProjectDetailResponse;
import com.paws.devocean.dto.ProjectListResponse;
import com.paws.devocean.dto.ProjectResponse;
import com.paws.devocean.entity.Project;
import com.paws.devocean.repository.ProjectRepository;
import com.paws.devocean.vo.Type;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectListResponse getProject(Type type) {
        return new ProjectListResponse(
                projectRepository.findAllByType(type).stream()
                        .map(project -> ProjectResponse.builder()
                                .thumbnail(project.getThumbnail())
                                .title(project.getTitle())
                                .project_id(project.getId())
                                .build())
                        .toList()
        );
    }

    public ProjectDetailResponse getProjectById(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        return ProjectDetailResponse.builder()
                .title(project.getTitle())
                .content(project.getContent())
                .build();
    }
}