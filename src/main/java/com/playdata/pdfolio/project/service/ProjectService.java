package com.playdata.pdfolio.project.service;

import com.playdata.pdfolio.domain.entity.common.Skill;
import com.playdata.pdfolio.domain.entity.member.Member;
import com.playdata.pdfolio.domain.entity.project.Project;
import com.playdata.pdfolio.domain.entity.project.ProjectSkill;
import com.playdata.pdfolio.domain.entity.project.Url;
import com.playdata.pdfolio.domain.request.project.ProjectCreateRequest;
import com.playdata.pdfolio.domain.response.project.ProjectCreateResponse;
import com.playdata.pdfolio.project.repository.ProjectRepository;
import com.playdata.pdfolio.project.repository.ProjectSkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectSkillRepository projectSkillRepository;

    @Transactional
    public ProjectCreateResponse save(ProjectCreateRequest request, Long memberId) {
//        Member member = Member.getMemberProxy(memberId);
//        Project project = createProject(request, member);
//        List<Skill> skills = Skill.of(request.getProjectSkills());
//
//        Project savedProject = projectRepository.save(project);
//
//        List<ProjectSkill> projectSkills = createProjectSkills(savedProject, skills);
//        projectSkillRepository.saveAll(projectSkills);

//        return ProjectCreateResponse.of(savedProject);

        return null;
    }


    private List<ProjectSkill> createProjectSkills(Project project, List<Skill> skills) {
        return skills.stream()
                .map(skill -> ProjectSkill.builder()
                                .project(project)
                                .skill(skill)
                                .build())
                .toList();
    }

    private Project createProject(ProjectCreateRequest request, Member member) {
        return Project.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .description(request.getDescription())
                .repositoryUrl(Url.of(request.getRepositoryUrl()))
                .publishUrl(Url.of(request.getPublishUrl()))
                .thumbNailUrl(Url.of(request.getThumbNailUrl()))
                .member(member)
                .build();
    }
}
