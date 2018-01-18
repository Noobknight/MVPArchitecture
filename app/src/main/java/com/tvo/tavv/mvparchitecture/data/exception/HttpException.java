package com.tvo.tavv.mvparchitecture.data.exception;

import android.support.annotation.NonNull;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public class HttpException extends Exception {
    private final int code;
    @NonNull
    private final String message;

    public HttpException(final int code, @NonNull final String message) {
        super("HTTP " + code + " " + message);
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    @NonNull
    public String message() {
        return message;
    }
}