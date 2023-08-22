package com.playdata.pdfolio.domain.entity.project;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProjectReply is a Querydsl query type for ProjectReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectReply extends EntityPathBase<ProjectReply> {

    private static final long serialVersionUID = 745798435L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProjectReply projectReply = new QProjectReply("projectReply");

    public final com.playdata.pdfolio.domain.entity.common.QBaseEntity _super = new com.playdata.pdfolio.domain.entity.common.QBaseEntity(this);

    public final QProjectComment comment;

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

    public QProjectReply(String variable) {
        this(ProjectReply.class, forVariable(variable), INITS);
    }

    public QProjectReply(Path<? extends ProjectReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProjectReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProjectReply(PathMetadata metadata, PathInits inits) {
        this(ProjectReply.class, metadata, inits);
    }

    public QProjectReply(Class<? extends ProjectReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comment = inits.isInitialized("comment") ? new QProjectComment(forProperty("comment"), inits.get("comment")) : null;
        this.member = inits.isInitialized("member") ? new com.playdata.pdfolio.domain.entity.member.QMember(forProperty("member")) : null;
    }

}

