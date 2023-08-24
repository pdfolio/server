package com.playdata.pdfolio.domain.response.project;

import com.playdata.pdfolio.domain.entity.project.Project;
import com.playdata.pdfolio.domain.response.member.MemberInfoResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProjectResponse {

    private Long projectId;
    private String title;
    private String description;
    private Integer heartCount;
    private Integer viewCount;
    private Long commentCount;
    private String thumbNailUrl;
    private String createdAt;
    private List<ProjectSkillResponse> projectSkills;
    private MemberInfoResponse author;

    public ProjectResponse(
            final Long projectId,
            final String title,
            final String description,
            final Integer heartCount,
            final Integer viewCount,
            final Long commentCount,
            final String thumbNailUrl,
            final LocalDateTime createdAt,
            final List<ProjectSkillResponse> projectSkills,
            final MemberInfoResponse memberInfoResponse) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.heartCount = heartCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.thumbNailUrl = thumbNailUrl;
        this.createdAt = createdAt.toString();
        this.projectSkills = projectSkills;
        this.author = memberInfoResponse;
    }

    public static ProjectResponse of(final Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getHeartCount(),
                project.getViewCount(),
                project.getCommentCount(),
                project.getThumbNailUrl().getUrl(),
                project.getCreatedAt(),
                getProjectSkills(project),
                getMemberInfoResponse(project)
        );
    }

    private static List<ProjectSkillResponse> getProjectSkills(Project project) {
        return ProjectSkillResponse.of(project.getSkills());
    }

    private static MemberInfoResponse getMemberInfoResponse(Project project) {
        return MemberInfoResponse.of(project.getMember());
    }
}
