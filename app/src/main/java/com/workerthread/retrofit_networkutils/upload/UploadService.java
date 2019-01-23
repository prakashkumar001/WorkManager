package com.workerthread.retrofit_networkutils.upload;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


import com.workerthread.retrofit_networkutils.retrofit.APIClient;
import com.workerthread.retrofit_networkutils.retrofit.APIInterface;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class UploadService extends IntentService {
    public UploadService() {
        super("");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {


            if (intent.hasExtra("url") && intent.hasExtra("requestBody")) {

                //this.resultListener=(NetWorkResultListener)intent.getSerializableExtra("listener");
                String url = intent.getStringExtra("url");
                List<FileUpload> imageUploads = (List<FileUpload>) intent.getSerializableExtra("requestBody");

                if (imageUploads != null)
                    postMultipart(url, imageUploads);
            }
        }
    }

    public void postMultipart(final String url, List<FileUpload> images) {
        Call call = null;

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);


        // Map is used to multipart the file using okhttp3.RequestBody
        // Multiple Images
        for (int i = 0; i < images.size(); i++) {
            File file = new File(images.get(i).getFilePath());
            builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));

        }


        final MultipartBody requestBody = builder.build();

        call=apiInterface.multiPartUpload(url,requestBody);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, retrofit2.Response response) {

                Log.i("TEST","TEST");

               // resultListener.onSuccess(response.body());
                sendMessage(response.body().toString(),url);
                //resultListener.onSuccess(response.body().toString());

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.i("TEST","TEST");
              //  resultListener.onFailure(t.getMessage());
                //resultListener.onFailure(t.getMessage());
                call.cancel();
            }
        });

    }


    private void sendMessage(String response, String url) {

        Log.d("sender", "Broadcasting message" + response);
        Intent intent = new Intent("Url");

        // You can also include some extra data.
        intent.putExtra("response", response);
        intent.putExtra("url", url);
        LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(intent);
    }

}