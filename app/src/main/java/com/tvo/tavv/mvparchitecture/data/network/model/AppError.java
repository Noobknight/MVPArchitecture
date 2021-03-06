package com.tvo.tavv.mvparchitecture.data.network.model;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.HttpException;
import retrofit2.Response;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

/**
 * Author: Tavv
 * Created on 22/12/2017.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public final class AppError extends Throwable {

    public static final String DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again.";
    public static final String NETWORK_ERROR_MESSAGE = "No Internet Connection!";
    private static final String ERROR_MESSAGE_HEADER = "Error-Message";
    public static final String DEFAULT_SERVER_ERROR_MSG = "Can't connect to Server, Please try again later !";
    public static final String DEFAULT_NETWORK_ERROR_MSG = "Connecting internet has problem !";


    private final Throwable error;
    public static final boolean ENABLE_CATCH_TIME_OUT = true;
    private final int statusCode;

    public AppError(Throwable e) {
        super(e);
        this.error = e;
        statusCode = -1;
    }

    public AppError(Throwable e, int statusCode) {
        super(e);
        this.error = e;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return error.getMessage();
    }

    public boolean isAuthFailure() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_UNAUTHORIZED;
    }

    public boolean isResponseNull() {
        return error instanceof HttpException && ((HttpException) error).response() == null;
    }

    public String getAppErrorMessage() {
        if (this.error instanceof IOException) return NETWORK_ERROR_MESSAGE;
        if (!(this.error instanceof HttpException)) return DEFAULT_ERROR_MESSAGE;
        Response<?> response = ((HttpException) this.error).response();
        if (response != null) {
            String status = getJsonStringFromResponse(response);
            if (!TextUtils.isEmpty(status)) return status;

            Map<String, List<String>> headers = response.headers().toMultimap();
            if (headers.containsKey(ERROR_MESSAGE_HEADER))
                return headers.get(ERROR_MESSAGE_HEADER).get(0);
        }

        return DEFAULT_ERROR_MESSAGE;
    }

    public String getJsonStringFromResponse(final Response<?> response) {
        try {
            String jsonString = response.errorBody().string();
            Response errorResponse = new Gson().fromJson(jsonString, Response.class);
            return errorResponse.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Throwable getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppError that = (AppError) o;

        return error != null ? error.equals(that.error) : that.error == null;

    }

    @Override
    public int hashCode() {
        return error != null ? error.hashCode() : 0;
    }
}
