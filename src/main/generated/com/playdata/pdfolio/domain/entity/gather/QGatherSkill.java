package com.playdata.pdfolio.domain.entity.gather;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGatherSkill is a Querydsl query type for GatherSkill
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGatherSkill extends EntityPathBase<GatherSkill> {

    private static final long serialVersionUID = -892104768L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGatherSkill gatherSkill = new QGatherSkill("gatherSkill");

    public final QGather gather;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.playdata.pdfolio.domain.entity.common.Skill> skill = createEnum("skill", com.playdata.pdfolio.domain.entity.common.Skill.class);

    public QGatherSkill(String variable) {
        this(GatherSkill.class, forVariable(variable), INITS);
    }

    public QGatherSkill(Path<? extends GatherSkill> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGatherSkill(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGatherSkill(PathMetadata metadata, PathInits inits) {
        this(GatherSkill.class, metadata, inits);
    }

    public QGatherSkill(Class<? extends GatherSkill> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gather = inits.isInitialized("gather") ? new QGather(forProperty("gather")) : null;
    }

}

