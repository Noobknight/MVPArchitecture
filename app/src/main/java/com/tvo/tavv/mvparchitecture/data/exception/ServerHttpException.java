package com.tvo.tavv.mvparchitecture.data.exception;

import android.support.annotation.NonNull;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public class ServerHttpException extends HttpException {

    public ServerHttpException(final int code, @NonNull final String message) {
        super(code, message);
    }

}