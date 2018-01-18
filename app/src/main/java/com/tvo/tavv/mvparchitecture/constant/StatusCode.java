package com.tvo.tavv.mvparchitecture.constant;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public enum StatusCode {

    STATUS_OK(200),
    STATUS_ACCEPTED(202),
    STATUS_NO_CONTENT(204),
    STATUS_BAD_REQUEST(400),
    STATUS_UNAUTHORIZED(401),
    STATUS_FORBIDDEN(403),
    STATUS_NOT_FOUND(404),
    STATUS_METHOD_NOT_ALLOWED(405),
    STATUS_INTERNAL_SERVER(500),
    STATUS_SERVICE_UNAVAILABLE(503),
    UNKNOW(999);

    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static boolean contains(int code) {

        for (StatusCode c : StatusCode.values()) {
            if (c.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    public static StatusCode fromCode(int code) {
        for (StatusCode type : StatusCode.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }
}
