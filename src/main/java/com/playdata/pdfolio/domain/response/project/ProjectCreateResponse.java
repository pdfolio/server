package com.playdata.pdfolio.domain.response.project;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectCreateResponse {

    private ProjectResponse projectResponse;

    private ProjectCreateResponse(ProjectResponse projectResponse) {
        this.projectResponse = projectResponse;
    }

    public static ProjectCreateResponse from(ProjectResponse projectResponse) {
        return new ProjectCreateResponse(projectResponse);
    }
}
