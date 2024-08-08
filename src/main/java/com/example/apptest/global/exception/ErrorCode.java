package com.example.apptest.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    //프로젝트 관련사항
    PROJECT_NOT_FOUND("프로젝트를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),

    //리뷰 관련사항
    REVIEW_NOT_FOUND("리뷰를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_REVIEW_DATA("유효하지 않은 리뷰 데이터입니다.", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus status;

    ErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
