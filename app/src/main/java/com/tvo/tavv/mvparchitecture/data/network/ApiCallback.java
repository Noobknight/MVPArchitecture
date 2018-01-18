package com.tvo.tavv.mvparchitecture.data.network;

import com.tvo.tavv.mvparchitecture.data.error.AppErrorHandler;

import org.reactivestreams.Subscriber;

/**
 * Author: Tavv
 * Created on 21/12/2017.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public abstract class ApiCallback<T> implements Subscriber<T> {
    protected abstract void onSuccess(T response);

    protected abstract void onFailure(AppErrorHandler error);

    protected abstract void onFinish();

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onComplete() {
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onFinish();
    }
}
