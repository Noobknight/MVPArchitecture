package com.tvo.tavv.mvparchitecture.data.exception;

import android.support.annotation.NonNull;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public class NoInternetConnectionException extends Exception {
    private int statusCode = 799;

    public NoInternetConnectionException() {
    }

    public NoInternetConnectionException(@NonNull final String detailMessage) {
        super(detailMessage);
    }

    public int getStatusCode() {
        return statusCode;
    }
}