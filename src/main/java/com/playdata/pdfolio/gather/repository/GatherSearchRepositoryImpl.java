package com.playdata.pdfolio.gather.repository;

import com.playdata.pdfolio.domain.dto.gather.SearchDto;
import com.playdata.pdfolio.domain.entity.gather.Gather;
import com.playdata.pdfolio.domain.entity.gather.QGather;
import com.playdata.pdfolio.domain.response.gather.GatherResponse;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.playdata.pdfolio.domain.entity.gather.QGather.gather;
import static com.playdata.pdfolio.domain.entity.member.QMember.member;

@Repository
@RequiredArgsConstructor
public class GatherSearchRepositoryImpl implements GatherSearchRepository{
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<GatherResponse> findAllByCondition(
            PageRequest request,
            SearchDto condition
    ){
        JPAQuery<Gather> query = queryFactory
                .select(gather)
                .from(gather)
                .leftJoin(gather.member, member)
                .fetchJoin()
                .where(
                        contentContains(condition.getContent())
                )
                .offset(request.getPageNumber())
                .limit(request.getPageSize());

        List<Gather> gathers = query.fetch();
        List<GatherResponse> gatherResponses = GatherResponse.of(gathers);

        Long totalSize = queryFactory
                .select(gather.count())
                .from(gather)
                .where(
                        contentContains(condition.getContent())
                )
                .fetchOne();

        return new PageImpl<>(gatherResponses, request, totalSize);
    }

    private BooleanExpression contentContains(String content) {
        return content == null
                ? null
                : gather.content.contains(content);
    }

}
