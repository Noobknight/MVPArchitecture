package com.tvo.tavv.mvparchitecture.data.network;

import com.tvo.tavv.mvparchitecture.data.network.model.AppError;

import org.reactivestreams.Subscriber;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * Author: Tavv
 * Created on 21/12/2017.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public abstract class ApiCallback<T> implements Subscriber<T> {
    protected abstract void onSuccess(T response);

    protected abstract void onFailure(AppError error);

    protected abstract void onFinish();

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        String status;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
        } else if (e instanceof ConnectException) {
            String msg = AppError.DEFAULT_SERVER_ERROR_MSG;
        } else if (e instanceof SocketTimeoutException || e instanceof UnknownHostException) {
        } else {
            String msgServer = e.getMessage();
        }
        onFinish();
    }
}
