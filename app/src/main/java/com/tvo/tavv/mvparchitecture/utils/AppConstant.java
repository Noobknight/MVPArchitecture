package com.tvo.tavv.mvparchitecture.utils;

/**
 * Author: Tavv
 * Created on 22/12/2017.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public class AppConstant {

    public interface ICode {
        int STATUS_OK = 200;
        int STATUS_ACCEPTED = 202;
        int STATUS_NO_CONTENT = 204;
        int STATUS_BAD_REQUEST = 400;
        int STATUS_UNAUTHORIZED = 401;
        int STATUS_FORBIDDEN = 403;
        int STATUS_NOT_FOUND = 404;
        int STATUS_METHOD_NOT_ALLOWED = 405;
        int STATUS_INTERNAL_SERVER = 500;
        int STATUS_SERVICE_UNAVAILABLE = 503;
    }

    public interface IMessage {
        final String DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again.";
        final String NETWORK_ERROR_MESSAGE = "No Internet Connection!";
        final String ERROR_MESSAGE_HEADER = "Error-Message";
        final String DEFAULT_SERVER_ERROR_MSG = "Can't connect to Server, Please try again later !";
        final String DEFAULT_NETWORK_ERROR_MSG = "Connecting internet has problem !";
    }


}
