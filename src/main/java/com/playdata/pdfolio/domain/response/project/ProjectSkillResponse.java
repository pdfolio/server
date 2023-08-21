package com.playdata.pdfolio.domain.response.project;

import com.playdata.pdfolio.domain.entity.project.ProjectSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectSkillResponse {

    private String skillName;

    private ProjectSkillResponse(String skillName) {
        this.skillName = skillName;
    }

    public static ProjectSkillResponse from(ProjectSkill projectSkill) {
        return new ProjectSkillResponse(projectSkill.getSkillName());
    }
}
