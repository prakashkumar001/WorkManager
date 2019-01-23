package com.workerthread.worker;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.workerthread.R;
import com.workerthread.retrofit_networkutils.retrofit.APIClient;
import com.workerthread.retrofit_networkutils.retrofit.APIInterface;
import com.workerthread.retrofit_networkutils.upload.FileUpload;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class MyWorker extends Worker {
    //a public static string that will be used as the key
    //for sending and receiving data
    public static final String TASK_DESC = "task_desc";
    public static final String URL = "url";
    public static final String MULTI_PART_REQUEST = "multipart_request";
    public static final String MULTI_PART_RESPONSE = "multipart_response";


    WorkerParameters parameters;
    Data data;
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.parameters = workerParams;
    }

    /*
     * This method is responsible for doing the work
     * so whatever work that is needed to be performed
     * we will put it here
     *
     * For example, here I am calling the method displayNotification()
     * It will display a notification
     * So that we will understand the work is executed
     * */

    @NonNull
    @Override
    public Result doWork() {
        //getting the input data
        // String taskDesc = getInputData().getString(TASK_DESC);

        //displayNotification("My Worker", taskDesc);



        Call call = null;

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        call = apiInterface.callPostMethod(parameters.getInputData().getString(MyWorker.URL), new JsonObject());

        try {

            String response= call.execute().body().toString();
            data = new Data.Builder().putString(MyWorker.MULTI_PART_RESPONSE, response).build();
            setOutputData(data);
            if(data!=null)
                return Result.SUCCESS;
            else
                return Result.FAILURE;

        } catch (IOException e) {
            e.printStackTrace();
            return Result.FAILURE;
        }



    }

    /*
     * The method is doing nothing but only generating
     * a simple notification
     * If you are confused about it
     * you should check the Android Notification Tutorial
     * */
    private void displayNotification(String title, String task) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("simplifiedcoding", "simplifiedcoding", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "simplifiedcoding")
                .setContentTitle(title)
                .setContentText(task)
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(1, notification.build());
    }

    // Deserialize to single object.
    public List<FileUpload> deserializeFromJson(String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<FileUpload>>() {
        }.getType();

        List<FileUpload> myClass = gson.fromJson(jsonString, listType);
        return myClass;
    }

    Result callApi() {

        /*MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);


        // Map is used to multipart the file using okhttp3.RequestBody
        // Multiple Images
        List<FileUpload> images = deserializeFromJson(parameters.getInputData().getString(MyWorker.MULTI_PART_REQUEST));
        for (int i = 0; i < images.size(); i++) {
            File file = new File(images.get(i).getFilePath());
            builder.addFormDataPart("file[]", "name", RequestBody.create(MediaType.parse("multipart/form-data"), file));

        }


        final MultipartBody requestBody = builder.build();*/
        Call call = null;

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        call = apiInterface.callPostMethod(parameters.getInputData().getString(MyWorker.URL), new JsonObject());

        try {

            String response= call.execute().body().toString();
            data = new Data.Builder().putString(MyWorker.MULTI_PART_RESPONSE, response).build();
            setOutputData(data);
            if(data!=null)
                return Result.SUCCESS;
            else
                return Result.FAILURE;

        } catch (IOException e) {
            e.printStackTrace();
            return Result.FAILURE;
        }
        /*call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, final retrofit2.Response response) {

                Log.i("TEST", "TEST" + response.body().toString());


                data = new Data.Builder().putString(MyWorker.MULTI_PART_RESPONSE, response.body().toString()).build();
                setOutputData(data);



            }

            @Override
            public void onFailure(Call call, Throwable t) {


                call.cancel();
            }
        });*/



    }
}