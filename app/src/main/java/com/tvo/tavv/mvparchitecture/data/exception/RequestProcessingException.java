package com.tvo.tavv.mvparchitecture.data.exception;

import android.support.annotation.NonNull;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public class RequestProcessingException extends Exception {

    private int statusCode;

    @NonNull
    private final String reasonMessage;

    public RequestProcessingException(@NonNull final String reasonMessage) {
        super(reasonMessage);
        this.reasonMessage = reasonMessage;
    }

    @NonNull
    public String getReasonMessage() {
        return reasonMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }
}