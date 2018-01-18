package com.tvo.tavv.mvparchitecture.data.error;

import com.tvo.tavv.mvparchitecture.constant.AppStatusCode;
import com.tvo.tavv.mvparchitecture.constant.StatusCode;

import org.apache.commons.lang3.StringUtils;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public class MessageFactory {

    public String getMessage(StatusCode statusCode) {
        //TODO : Define detail message for each status code
        //Should be define message in AppMessage.java
        switch (statusCode) {
            case STATUS_OK:
                return "";
            case STATUS_ACCEPTED:
                return "";
            case STATUS_BAD_REQUEST:
                return "";
            case STATUS_FORBIDDEN:
                return "";
            case STATUS_INTERNAL_SERVER:
                return "";
            case STATUS_METHOD_NOT_ALLOWED:
                return "";
            case STATUS_NO_CONTENT:
                return "";
            case STATUS_NOT_FOUND:
                return "";
            case STATUS_SERVICE_UNAVAILABLE:
                return "";
            case STATUS_UNAUTHORIZED:
                return "";
            case UNKNOW:
                return "";
            default:
                return StringUtils.EMPTY;
        }
    }

    public String getMessage(int statusCode) {
        if (StatusCode.contains(statusCode)) {
            //TODO : Define detail message for each status code
            //Should be define message in AppMessage.java
            StatusCode code = StatusCode.fromCode(statusCode);
            switch (code) {
                case STATUS_OK:
                    return "";
                case STATUS_ACCEPTED:
                    return "";
                case STATUS_BAD_REQUEST:
                    return "";
                case STATUS_FORBIDDEN:
                    return "";
                case STATUS_INTERNAL_SERVER:
                    return "";
                case STATUS_METHOD_NOT_ALLOWED:
                    return "";
                case STATUS_NO_CONTENT:
                    return "";
                case STATUS_NOT_FOUND:
                    return "";
                case STATUS_SERVICE_UNAVAILABLE:
                    return "";
                case STATUS_UNAUTHORIZED:
                    return "";
                case UNKNOW:
                    return "";
                default:
                    return StringUtils.EMPTY;
            }
        } else {
            AppStatusCode appStatusCode = AppStatusCode.fromCode(statusCode);
            switch (appStatusCode) {
                case APPCODE:
                    return "";
            }
        }
        return "";
    }
}
