package com.playdata.pdfolio.project.controller;

import com.playdata.pdfolio.auth.UserInfo;
import com.playdata.pdfolio.domain.request.project.ProjectCreateRequest;
import com.playdata.pdfolio.domain.request.project.ProjectSearchParameter;
import com.playdata.pdfolio.domain.response.project.ProjectCreateResponse;
import com.playdata.pdfolio.domain.response.project.ProjectDetailResponse;
import com.playdata.pdfolio.domain.response.project.ProjectListResponse;
import com.playdata.pdfolio.project.resolver.ProjectSearchParams;
import com.playdata.pdfolio.project.service.ProjectService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectCreateResponse> save(
            @RequestBody ProjectCreateRequest projectCreateRequest,
            @AuthenticationPrincipal UserInfo userInfo) {
        ProjectCreateResponse response = projectService.save(
                projectCreateRequest,
                userInfo.getMemberId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDetailResponse> findById(@PathVariable Long id) {
        ProjectDetailResponse response = projectService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<ProjectListResponse> search(@ProjectSearchParams ProjectSearchParameter searchParameter) {
        ProjectListResponse response = projectService.search(searchParameter);
        return ResponseEntity.ok(response);
    }
}
