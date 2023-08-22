package com.playdata.pdfolio.domain.entity.heart;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGatherHeart is a Querydsl query type for GatherHeart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGatherHeart extends EntityPathBase<GatherHeart> {

    private static final long serialVersionUID = 99127142L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGatherHeart gatherHeart = new QGatherHeart("gatherHeart");

    public final com.playdata.pdfolio.domain.entity.gather.QGather gather;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.playdata.pdfolio.domain.entity.member.QMember member;

    public QGatherHeart(String variable) {
        this(GatherHeart.class, forVariable(variable), INITS);
    }

    public QGatherHeart(Path<? extends GatherHeart> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGatherHeart(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGatherHeart(PathMetadata metadata, PathInits inits) {
        this(GatherHeart.class, metadata, inits);
    }

    public QGatherHeart(Class<? extends GatherHeart> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gather = inits.isInitialized("gather") ? new com.playdata.pdfolio.domain.entity.gather.QGather(forProperty("gather"), inits.get("gather")) : null;
        this.member = inits.isInitialized("member") ? new com.playdata.pdfolio.domain.entity.member.QMember(forProperty("member")) : null;
    }

}

