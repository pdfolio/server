package com.playdata.pdfolio.domain.entity.heart;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProjectHeart is a Querydsl query type for ProjectHeart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProjectHeart extends EntityPathBase<ProjectHeart> {

    private static final long serialVersionUID = 1924292530L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProjectHeart projectHeart = new QProjectHeart("projectHeart");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.playdata.pdfolio.domain.entity.member.QMember member;

    public final com.playdata.pdfolio.domain.entity.project.QProject project;

    public QProjectHeart(String variable) {
        this(ProjectHeart.class, forVariable(variable), INITS);
    }

    public QProjectHeart(Path<? extends ProjectHeart> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProjectHeart(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProjectHeart(PathMetadata metadata, PathInits inits) {
        this(ProjectHeart.class, metadata, inits);
    }

    public QProjectHeart(Class<? extends ProjectHeart> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.playdata.pdfolio.domain.entity.member.QMember(forProperty("member")) : null;
        this.project = inits.isInitialized("project") ? new com.playdata.pdfolio.domain.entity.project.QProject(forProperty("project"), inits.get("project")) : null;
    }

}

