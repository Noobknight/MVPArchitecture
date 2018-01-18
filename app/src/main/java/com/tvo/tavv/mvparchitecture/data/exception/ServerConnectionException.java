package com.tvo.tavv.mvparchitecture.data.exception;

import android.support.annotation.NonNull;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public class ServerConnectionException extends Exception {

    private int statusCode;

    public ServerConnectionException() {
    }


    public ServerConnectionException(@NonNull final String detailMessage) {
        super(detailMessage);
    }

    public int getStatusCode() {
        return statusCode;
    }
}