package com.playdata.pdfolio.domain.request.project;

import com.playdata.pdfolio.project.exception.InValidProjectSearchTypeException;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum ProjectSearchSortType {

    CREATED_AT("createdAt"),
    VIEW_COUNT("viewCount"),
    HEART_COUNT("heartCount")
    ;

    private String value;

    ProjectSearchSortType(String value) {
        this.value = value;
    }

    public static ProjectSearchSortType of(String value) {
        if (Objects.isNull(value)) {
            return CREATED_AT;
        }

        return Arrays.stream(values())
                .filter(type -> type.value.equals(value))
                .findFirst()
                .orElseThrow(InValidProjectSearchTypeException::new);
    }

}
