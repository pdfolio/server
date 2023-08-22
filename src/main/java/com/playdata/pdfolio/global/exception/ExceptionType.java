package com.playdata.pdfolio.global.exception;

import com.playdata.pdfolio.project.exception.InValidUrlTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ExceptionType {

    UNKNOWN_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "알수없는 에러"),
    COLUMN_ALREADY_DELETED(HttpStatus.BAD_REQUEST, "이미 삭제된 컬럼입니다.", ColumnAlreadyDeletedException.class),
    NO_MATCHING_SKILL_TYPE(HttpStatus.BAD_REQUEST, "해당 기술 스택은 존재하지 않습니다.", NoSuchSkillException.class),
    INVALID_URL_TYPE(HttpStatus.BAD_REQUEST, "유효하지 않는 URL 타입입니다.", InValidUrlTypeException.class),

//    MEMBER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다.",MemberNotFoundException.class),
    ;

    private final HttpStatus httpStatus;
    private final String message;
    private Class<? extends PdFolioException> type;

    ExceptionType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public static ExceptionType of(Class<? extends PdFolioException> classType) {
        return Arrays.stream(values())
                .filter(eType -> Objects.nonNull(eType.type) && eType.type.equals(classType))
                .findFirst()
                .orElse(UNKNOWN_EXCEPTION);
    }
}
