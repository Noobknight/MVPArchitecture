package com.tvo.tavv.mvparchitecture.constant;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public enum AppStatusCode {

    APPCODE(999);

    private final int code;

    AppStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AppStatusCode fromCode(int code) {
        for (AppStatusCode type : AppStatusCode.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }
}
