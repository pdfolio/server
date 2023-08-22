package com.playdata.pdfolio.domain.entity.gather;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGatherComment is a Querydsl query type for GatherComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGatherComment extends EntityPathBase<GatherComment> {

    private static final long serialVersionUID = 483857422L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGatherComment gatherComment = new QGatherComment("gatherComment");

    public final com.playdata.pdfolio.domain.entity.common.QBaseEntity _super = new com.playdata.pdfolio.domain.entity.common.QBaseEntity(this);

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

    public final com.playdata.pdfolio.domain.entity.project.QProject project;

    public final ListPath<GatherReply, QGatherReply> replies = this.<GatherReply, QGatherReply>createList("replies", GatherReply.class, QGatherReply.class, PathInits.DIRECT2);

    public QGatherComment(String variable) {
        this(GatherComment.class, forVariable(variable), INITS);
    }

    public QGatherComment(Path<? extends GatherComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGatherComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGatherComment(PathMetadata metadata, PathInits inits) {
        this(GatherComment.class, metadata, inits);
    }

    public QGatherComment(Class<? extends GatherComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.playdata.pdfolio.domain.entity.member.QMember(forProperty("member")) : null;
        this.project = inits.isInitialized("project") ? new com.playdata.pdfolio.domain.entity.project.QProject(forProperty("project"), inits.get("project")) : null;
    }

}

