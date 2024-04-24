package com.valiit.pvback.infrastructure.error;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    INVALID_EMAIL("Vale email", 222);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
