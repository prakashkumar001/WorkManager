package com.workerthread.retrofit_networkutils.listener;

import java.io.Serializable;

public interface NetWorkResultListener extends Serializable{
    void onSuccess(Object response, String requestType);
    void onFailure(String requestType, String error);
}
