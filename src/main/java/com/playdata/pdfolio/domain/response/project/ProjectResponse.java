package com.playdata.pdfolio.domain.response.project;

import com.playdata.pdfolio.domain.entity.project.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProjectResponse {

    private Long projectId;
    private String title;
    private String description;
    private Integer heartCount;
    private Integer viewCount;
    private Integer commentCount;
    private String thumbNailUrl;

    private List<ProjectSkillResponse> projectSkills;

    private Long memberId;
    private String memberName;

    public ProjectResponse(
            final Long projectId,
            final String title,
            final String description,
            final Integer heartCount,
            final Integer viewCount,
            final Integer commentCount,
            final String thumbNailUrl,
            final List<ProjectSkillResponse> projectSkills,
            final Long memberId,
            final String memberName) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.heartCount = heartCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.thumbNailUrl = thumbNailUrl;
        this.projectSkills = projectSkills;
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public static ProjectResponse from(Project project) {
        List<ProjectSkillResponse> projectSkills = project.getSkills()
                .stream()
                .map(ProjectSkillResponse::from)
                .toList();

        return new ProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getHeartCount(),
                project.getViewCount(),
                project.getCommentCount(),
                project.getThumbNailUrl().getUrl(),
                projectSkills,
                project.getMember().getId(),
                project.getMember().getName()
        );
    }
}
