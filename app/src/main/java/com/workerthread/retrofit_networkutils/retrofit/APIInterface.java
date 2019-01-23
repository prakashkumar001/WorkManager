package com.workerthread.retrofit_networkutils.retrofit;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface APIInterface {

    @GET
    Call<Object> callGetMethod(@Url String url);

    @GET
    Call<Object> callGetMethod(@Url String url, @Header("Authorization") String access_token);

    @POST()
    Call<Object> callPostMethod(@Url String url, @Body Object request);

    @POST()
    Call<Object> callPostMethod(@Url String url, @Body Object request, @Header("Authorization") String access_token);

    @POST
    Call<ResponseBody> multiPartUpload(@Url String url, @Body RequestBody files);

    @POST
    Call<Object> multiPartUpload(@Url String url, @Body RequestBody files, @Header("Authorization") String accesstoken);


}
