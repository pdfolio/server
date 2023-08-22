package com.playdata.pdfolio.domain.entity.gather;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGather is a Querydsl query type for Gather
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGather extends EntityPathBase<Gather> {

    private static final long serialVersionUID = 1118489873L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGather gather = new QGather("gather");

    public final com.playdata.pdfolio.domain.entity.common.QBaseEntity _super = new com.playdata.pdfolio.domain.entity.common.QBaseEntity(this);

    public final EnumPath<GatherCategory> category = createEnum("category", GatherCategory.class);

    public final DateTimePath<java.time.LocalDateTime> closeDate = createDateTime("closeDate", java.time.LocalDateTime.class);

    public final StringPath contact = createString("contact");

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final NumberPath<Integer> heartCount = createNumber("heartCount", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final com.playdata.pdfolio.domain.entity.member.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final SetPath<GatherSkill, QGatherSkill> skills = this.<GatherSkill, QGatherSkill>createSet("skills", GatherSkill.class, QGatherSkill.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> teamSize = createNumber("teamSize", Long.class);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public QGather(String variable) {
        this(Gather.class, forVariable(variable), INITS);
    }

    public QGather(Path<? extends Gather> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGather(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGather(PathMetadata metadata, PathInits inits) {
        this(Gather.class, metadata, inits);
    }

    public QGather(Class<? extends Gather> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.playdata.pdfolio.domain.entity.member.QMember(forProperty("member")) : null;
    }

}

