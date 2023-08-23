package com.playdata.pdfolio.domain.request.project;

import com.playdata.pdfolio.project.exception.InvalidPageException;
import com.playdata.pdfolio.project.exception.InvalidSizeException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjectSearchParameter {

    private static final int MIN_PAGE = 1;
    private static final int MIN_SIZE = 10;

    private int page;
    private int size;
    private ProjectSearchSortType sortType;
    private ProjectSearchSkillCategory skillCategory;

    public static ProjectSearchParameter of(String page, String size, String sortType, String skillCategory) {
        return new ProjectSearchParameter(
                initPage(page),
                initSize(size),
                ProjectSearchSortType.of(sortType),
                ProjectSearchSkillCategory.of(skillCategory)
        );
    }

    private static int initPage(String page) {
        try {
            int value = Integer.parseInt(page);
            if (value < MIN_PAGE) {
                throw new InvalidPageException();
            }
            return value;
        } catch (NumberFormatException e) {
            return MIN_PAGE;
        }
    }

    private static int initSize(String size) {
        try {
            int value = Integer.parseInt(size);
            if (value < MIN_SIZE) {
                throw new InvalidSizeException();
            }
            return value;
        } catch (NumberFormatException e) {
            return MIN_SIZE;
        }
    }

}
