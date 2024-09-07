package com.paws.devocean.controller;

import com.paws.devocean.dto.ProjectDetailResponse;
import com.paws.devocean.dto.ProjectListResponse;
import com.paws.devocean.service.ProjectService;
import com.paws.devocean.vo.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public ProjectListResponse getProjects(@RequestParam Type type) {
        return projectService.getProject(type);
    }

    @GetMapping("/{id}")
    public ProjectDetailResponse getProject(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }
}
