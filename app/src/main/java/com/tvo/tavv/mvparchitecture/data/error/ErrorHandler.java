package com.tvo.tavv.mvparchitecture.data.error;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public class ErrorHandler {

    @NonNull
    private final ErrorFactory errorFactory;

    public ErrorHandler(@NonNull final ErrorFactory errorFactory) {
        this.errorFactory = errorFactory;
    }

    @NonNull
    public static ErrorHandler defaultErrorHandler() {
        return new ErrorHandler(new AppErrorHandler());
    }

    public void handle(@NonNull final Throwable throwable, @NonNull final View root) {
        String message = errorFactory.build(root.getContext(), throwable);
        if (!TextUtils.isEmpty(message)) {
            Snackbar.make(root, message, Snackbar.LENGTH_LONG).show();
        }
    }
}
