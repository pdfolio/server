package com.playdata.pdfolio.domain.entity.gather;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGatherReply is a Querydsl query type for GatherReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGatherReply extends EntityPathBase<GatherReply> {

    private static final long serialVersionUID = -893200295L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGatherReply gatherReply = new QGatherReply("gatherReply");

    public final com.playdata.pdfolio.domain.entity.common.QBaseEntity _super = new com.playdata.pdfolio.domain.entity.common.QBaseEntity(this);

    public final QGatherComment comment;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final com.playdata.pdfolio.domain.entity.member.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public QGatherReply(String variable) {
        this(GatherReply.class, forVariable(variable), INITS);
    }

    public QGatherReply(Path<? extends GatherReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGatherReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGatherReply(PathMetadata metadata, PathInits inits) {
        this(GatherReply.class, metadata, inits);
    }

    public QGatherReply(Class<? extends GatherReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comment = inits.isInitialized("comment") ? new QGatherComment(forProperty("comment"), inits.get("comment")) : null;
        this.member = inits.isInitialized("member") ? new com.playdata.pdfolio.domain.entity.member.QMember(forProperty("member")) : null;
    }

}

