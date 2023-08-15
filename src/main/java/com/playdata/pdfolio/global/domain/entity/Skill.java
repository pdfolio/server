package com.playdata.pdfolio.global.domain.entity;

public enum Skill {

    // Language
    JAVA(SkillCategory.LANGUAGE),
    KOTLIN(SkillCategory.LANGUAGE),
    JAVASCRIPT(SkillCategory.LANGUAGE),
    TYPESCRIPT(SkillCategory.LANGUAGE),
    PYTHON(SkillCategory.LANGUAGE),
    PHP(SkillCategory.LANGUAGE),

    // Framework
    SPRING(SkillCategory.FRAMEWORK),
    NEST(SkillCategory.FRAMEWORK),
    EXPRESS(SkillCategory.FRAMEWORK),
    DJANGO(SkillCategory.FRAMEWORK),
    LARAVEL(SkillCategory.FRAMEWORK),
    REACT(SkillCategory.FRAMEWORK),
    VUE(SkillCategory.FRAMEWORK),
    NEXT(SkillCategory.FRAMEWORK),
    NUXT(SkillCategory.FRAMEWORK),


    // Database
    ORACLE(SkillCategory.DATABASE),
    MYSQL(SkillCategory.DATABASE),
    POSTGRESQL(SkillCategory.DATABASE),


    // Other
    AWS(SkillCategory.ETC),
    DOCKER(SkillCategory.ETC),
    GIT(SkillCategory.ETC);
    private final SkillCategory category;

    Skill(SkillCategory category) {
        this.category = category;
    }
}
