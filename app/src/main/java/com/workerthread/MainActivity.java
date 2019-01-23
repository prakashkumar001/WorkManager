package com.workerthread;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.workerthread.retrofit_networkutils.upload.FileUpload;
import com.workerthread.worker.MyWorker;

import java.util.ArrayList;
import java.util.List;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;

public class MainActivity extends AppCompatActivity {
     OneTimeWorkRequest workRequest;
     List<FileUpload> filepatharray;
    String request=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //This is the subclass of our WorkRequest





    }
    public String serializeToJson(List<FileUpload> uploads) {
        Gson gson = new Gson();
        request= gson.toJson(uploads);

       return request;
    }
    public void fun(View view) {
        //creating a data object
        //to pass the data with workRequest
        //we can put as many variables needed

        // Serialize a single object.
        getsampleData();
        serializeToJson(filepatharray);
        Data data = new Data.Builder()
                .putString(MyWorker.URL, "http://0dy0e.mocklab.io/thing/11/uploadpic")
                .putString(MyWorker.MULTI_PART_REQUEST,request).build();

        workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).
                setInputData(data).build();

        WorkManager.getInstance().enqueue(workRequest);
        //Listening to the work status
        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(@Nullable WorkInfo workInfo) {

                         String response=workInfo.getOutputData().getString(MyWorker.MULTI_PART_RESPONSE);
                        if(response!=null)
                        {

                            Log.e("RESPONSE","RESPONSE"+response);
                            //Displaying the status into TextView
                            Toast.makeText(getApplicationContext(),workInfo.getOutputData().getString(MyWorker.MULTI_PART_RESPONSE),Toast.LENGTH_SHORT).show();

                        }
                           }


                });
    }

    public void getsampleData()
    {
        filepatharray=new ArrayList<>();
        for(int i=0;i<3;i++)
        {
           filepatharray.add( new FileUpload("https://homepages.cae.wisc.edu/~ece533/images/goldhill.png"));


        }

    }
}
