package com.tvo.tavv.mvparchitecture.data.error;

import android.support.annotation.NonNull;

/**
 * Author: Tavv
 * Created on 18/01/2018.
 * Project Name: MVPArchitecture
 * Version : 1.0
 */

public interface ErrorFactory {
    @NonNull
    String getMessage();
}
