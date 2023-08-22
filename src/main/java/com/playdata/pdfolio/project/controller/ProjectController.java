package com.playdata.pdfolio.project.controller;

import com.playdata.pdfolio.domain.request.project.ProjectCreateRequest;
import com.playdata.pdfolio.domain.response.project.ProjectCreateResponse;
import com.playdata.pdfolio.project.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectCreateResponse> save(@Valid @RequestBody ProjectCreateRequest projectCreateRequest) {
        // 임시
        Long memberId = 1L;
        ProjectCreateResponse response = projectService.save(projectCreateRequest, memberId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }


}