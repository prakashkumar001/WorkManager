package com.workerthread.retrofit_networkutils.retrofit;




import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

      /*  OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                 Request.Builder builder = chain.request().newBuilder();

                for (Map.Entry<String, String> entry : NetWorkUtilBaseUrl.HEADER_PARAMS.entrySet()) {
                     builder.addHeader(entry.getKey(), entry.getValue()).build();

                }
                return chain.proceed(builder.build());
            }
        });*/
        retrofit = new Retrofit.Builder()
                .baseUrl("http://0dy0e.mocklab.io/thing/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



        return retrofit;
    }



}
