package com.playdata.pdfolio.project.repository;

import com.playdata.pdfolio.domain.entity.common.Skill;
import com.playdata.pdfolio.domain.request.project.ProjectSearchParameter;
import com.playdata.pdfolio.domain.response.member.MemberInfoResponse;
import com.playdata.pdfolio.domain.response.project.ProjectResponse;
import com.playdata.pdfolio.domain.response.project.ProjectSkillResponse;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static com.querydsl.core.group.GroupBy.*;
import static com.playdata.pdfolio.domain.entity.member.QMember.*;
import static com.playdata.pdfolio.domain.entity.project.QProject.*;
import static com.playdata.pdfolio.domain.entity.project.QProjectComment.*;
import static com.playdata.pdfolio.domain.entity.project.QProjectSkill.projectSkill;

@RequiredArgsConstructor
public class ProjectSearchRepositoryImpl implements ProjectSearchRepository {

    private final JPAQueryFactory queryFactory;

    public Page<ProjectResponse> findAllProjectByCondition(ProjectSearchParameter searchParameter) {
        // 전체 데이터 수를 구하기 위한 count 쿼리 실행
        long total = queryFactory
                .from(project)
                .distinct()
                .where(project.id.in(
                        JPAExpressions.select(projectSkill.project.id)
                                .from(projectSkill)
                                .where(projectSkillsIn(searchParameter.getSkillCategory().getSkillCategory()))
                ))
                .fetchCount();

        System.out.println(total);

//        List<ProjectResponse> content = queryFactory
//                .from(project)
//                .distinct()
//                .join(member).on(project.member.id.eq(member.id))
//                .leftJoin(projectComment).on(project.id.eq(projectComment.project.id))
//                .leftJoin(projectSkill).on(project.id.eq(projectSkill.project.id))
//                .where(project.id.in(
//                        JPAExpressions.select(projectSkill.project.id)
//                                .from(projectSkill)
//                                .where(projectSkillsIn(searchParameter.getSkillCategory().getSkillCategory()))
//                ))
//                .offset(searchParameter.getPageable().getOffset())
//                .limit(searchParameter.getPageable().getPageSize())
//                .transform(
//                        Projections.constructor(
//                                ProjectResponse.class,
//                                project.id.as("projectId"),
//                                project.title.as("title"),
//                                project.description.as("description"),
//                                project.heartCount.as("heartCount"),
//                                project.viewCount.as("viewCount"),
//                                projectComment.count().coalesce(0L).as("commentCount"),
//                                project.thumbNailUrl.as("thumbNailUrl"),
//                                project.createdAt.as("createdAt"),
//                                list(Projections.constructor(
//                                        ProjectSkillResponse.class,
//                                        projectSkill.skill).as("skillName")).as("projectSkills"),
//                                Projections.constructor(
//                                        MemberInfoResponse.class,
//                                        member.id.as("memberId"),
//                                        member.nickName.as("nickName"),
//                                        member.providerId.as("providerId"),
//                                        member.providerName.as("providerName"),
//                                        member.imageUrl.as("image")
//                                ).as("author")
//                        )
//                );

        ConstructorExpression<ProjectResponse> projectResponseConstructor = Projections.constructor(
                ProjectResponse.class,
                project.id.as("projectId"),
                project.title.as("title"),
                project.description.as("description"),
                project.heartCount.as("heartCount"),
                project.viewCount.as("viewCount"),
                projectComment.count().coalesce(0L).as("commentCount"),
                project.thumbNailUrl.as("thumbNailUrl"),
                project.createdAt.as("createdAt"),
                list(Projections.constructor(
                        ProjectSkillResponse.class,
                        projectSkill.skill).as("skillName")
                ).as("projectSkills"),
                Projections.constructor(
                        MemberInfoResponse.class,
                        member.id.as("memberId"),
                        member.nickName.as("nickName"),
                        member.providerId.as("providerId"),
                        member.providerName.as("providerName"),
                        member.imageUrl.as("image")
                ).as("author")
        );

        List<ProjectResponse> content = queryFactory
                .from(project)
                .distinct()
                .join(member).on(project.member.id.eq(member.id))
                .leftJoin(projectComment).on(project.id.eq(projectComment.project.id))
                .leftJoin(projectSkill).on(project.id.eq(projectSkill.project.id))
                .where(project.id.in(
                        JPAExpressions.select(projectSkill.project.id)
                                .from(projectSkill)
                                .where(projectSkillsIn(searchParameter.getSkillCategory().getSkillCategory()))
                ))
                .offset(searchParameter.getPageable().getOffset())
                .limit(searchParameter.getPageable().getPageSize())
                .select(projectResponseConstructor) // 이 부분에서 select로 ConstructorExpression을 선택합니다.
                .orderBy(projectOrderBy(searchParameter.getSortType().getValue())
                .fetch();

        return new PageImpl<>(content, searchParameter.getPageable(), total);
    }

    private BooleanExpression projectSkillsIn(List<String> projectSkills) {
        if (projectSkills.isEmpty()) {
            return null;
        }

        return projectSkill.skill.in(Skill.of(projectSkills));
    }

    private BooleanExpression projectOrderBy(String sortType) {
        if (sortType.equals("createdAt")) {
            return project.createdAt.desc();
        } else if (sortType.equals("viewCount")) {
            return project.heartCount.desc();
        } else if (sortType.equals("heartCount")) {
            return projectComment.count().desc();
        } else {
            return null;
        }
    }
}
