package com.playdata.pdfolio.domain.entity.project;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProjectComment is a Querydsl query type for ProjectComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectComment extends EntityPathBase<ProjectComment> {

    private static final long serialVersionUID = -691360680L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProjectComment projectComment = new QProjectComment("projectComment");

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

    public final QProject project;

    public final ListPath<ProjectReply, QProjectReply> replies = this.<ProjectReply, QProjectReply>createList("replies", ProjectReply.class, QProjectReply.class, PathInits.DIRECT2);

    public QProjectComment(String variable) {
        this(ProjectComment.class, forVariable(variable), INITS);
    }

    public QProjectComment(Path<? extends ProjectComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProjectComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProjectComment(PathMetadata metadata, PathInits inits) {
        this(ProjectComment.class, metadata, inits);
    }

    public QProjectComment(Class<? extends ProjectComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.playdata.pdfolio.domain.entity.member.QMember(forProperty("member")) : null;
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}

