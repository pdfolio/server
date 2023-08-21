package com.playdata.pdfolio.project.service;

import com.playdata.pdfolio.domain.request.project.ProjectCreateRequest;
import com.playdata.pdfolio.domain.response.project.ProjectCreateResponse;
import com.playdata.pdfolio.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public ProjectCreateResponse save(ProjectCreateRequest projectCreateRequest) {
        return null;
    }
}
