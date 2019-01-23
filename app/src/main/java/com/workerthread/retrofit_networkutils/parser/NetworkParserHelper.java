package com.workerthread.retrofit_networkutils.parser;


import android.support.annotation.NonNull;


import com.workerthread.retrofit_networkutils.ZencodeErrorCodes;
import com.workerthread.retrofit_networkutils.listener.NetWorkResultListener;
import com.workerthread.retrofit_networkutils.retrofit.APIClient;
import com.workerthread.retrofit_networkutils.retrofit.APIInterface;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkParserHelper {

    static Call call = null;
    static APIInterface apiInterface;
    NetWorkResultListener netWorkResultListener;

    public NetworkParserHelper() {

    }

    public void callApi(final String Url, String method, Object object, final NetWorkResultListener netWorkResultListener) throws IOException {
        this.netWorkResultListener = netWorkResultListener;

        call = null;

        apiInterface = APIClient.getClient().create(APIInterface.class);

        if (method.equalsIgnoreCase("POST")) {
            call = apiInterface.callPostMethod(Url, object);
        } else {
            call = apiInterface.callGetMethod(Url);
        }


        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.code() != 200) {
                    String error = ZencodeErrorCodes.getErrorMessage(response.code());
                    netWorkResultListener.onFailure(Url, error);

                } else {
                    netWorkResultListener.onSuccess(response.body(), Url);

                }


            }

            @Override
            public void onFailure(Call call, Throwable t) {
                netWorkResultListener.onFailure(Url, t.getMessage());
                call.cancel();

            }
        });

    }

    public void callApi(final String Url, String method, Object object, String accesstoken,
                        final NetWorkResultListener netWorkResultListener) throws IOException {
        this.netWorkResultListener = netWorkResultListener;

        call = null;

        apiInterface = APIClient.getClient().create(APIInterface.class);

        if (method.equalsIgnoreCase("POST")) {
            call = apiInterface.callPostMethod(Url, object, accesstoken);
        } else {
            call = apiInterface.callGetMethod(Url, accesstoken);
        }


        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                if (response.code() != 200) {
                    String error = ZencodeErrorCodes.getErrorMessage(response.code());
                    netWorkResultListener.onFailure(Url, error);

                }else {
                    netWorkResultListener.onSuccess(response.body(), Url);

                }


            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull Throwable t) {
                netWorkResultListener.onFailure(Url, t.getMessage());
                call.cancel();

            }
        });
    }

}
