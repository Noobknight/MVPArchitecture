package com.tvo.tavv.mvparchitecture.data.error;

import android.support.annotation.NonNull;

import com.tvo.tavv.mvparchitecture.data.exception.ClientHttpException;
import com.tvo.tavv.mvparchitecture.data.exception.NoInternetConnectionException;
import com.tvo.tavv.mvparchitecture.data.exception.RequestProcessingException;
import com.tvo.tavv.mvparchitecture.data.exception.ServerConnectionException;
import com.tvo.tavv.mvparchitecture.data.exception.ServerHttpException;

import org.apache.commons.lang3.StringUtils;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public class AppErrorHandler implements ErrorFactory {

    private MessageFactory messageFactory;

    private Throwable throwable;

    public AppErrorHandler(Throwable throwable) {
        this.throwable = throwable;
    }

    public AppErrorHandler(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    @NonNull
    @Override
    public String getMessage() {
        String msg = throwable.getMessage();
        if (StringUtils.isBlank(msg)) {
            int statusCode = 0;
            if (throwable instanceof NoInternetConnectionException) {
                statusCode = ((NoInternetConnectionException) throwable).getStatusCode();
            } else if (throwable instanceof ServerConnectionException) {
                statusCode = ((ServerConnectionException) throwable).getStatusCode();
            } else if (throwable instanceof RequestProcessingException) {
                statusCode = ((RequestProcessingException) throwable).getStatusCode();
            } else if (throwable instanceof ClientHttpException) {
                statusCode = ((ClientHttpException) throwable).code();
            } else if (throwable instanceof ServerHttpException) {
                statusCode = ((ClientHttpException) throwable).code();
            }
            return messageFactory.getMessage(statusCode);
        } else {
            return msg;
        }
    }

}
