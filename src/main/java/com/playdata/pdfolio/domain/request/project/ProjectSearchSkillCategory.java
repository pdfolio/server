package com.playdata.pdfolio.domain.request.project;

import com.playdata.pdfolio.domain.entity.common.Skill;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjectSearchSkillCategory {

    private List<String> skillCategory;

    public static ProjectSearchSkillCategory of(String skillCategory) {
        List<String> validSkillNames = Arrays.stream(skillCategory.split(","))
                .map(String::trim)
                .filter(
                        skillName -> Arrays.stream(Skill.values())
                        .anyMatch(
                                skill -> skill.getSkillName().equalsIgnoreCase(skillName)
                        )
                )
                .map(String::toUpperCase)
                .toList();

        return new ProjectSearchSkillCategory(validSkillNames);
    }

}
