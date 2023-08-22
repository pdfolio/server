package com.playdata.pdfolio.domain.response.project;

import com.playdata.pdfolio.domain.entity.project.ProjectSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProjectSkillResponse {

    private String skillName;

    private ProjectSkillResponse(String skillName) {
        this.skillName = skillName;
    }

    public static ProjectSkillResponse of(ProjectSkill projectSkill) {
        return new ProjectSkillResponse(projectSkill.getSkillName());
    }

    public static List<ProjectSkillResponse> of(List<ProjectSkill> projectSkills) {
        return projectSkills.stream()
                .map(ProjectSkillResponse::of)
                .toList();
    }
}
