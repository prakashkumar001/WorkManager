package com.workerthread.retrofit_networkutils.parser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;


import com.workerthread.retrofit_networkutils.listener.NetWorkResultListener;
import com.workerthread.retrofit_networkutils.upload.FileUpload;
import com.workerthread.retrofit_networkutils.upload.UploadService;

import java.io.Serializable;
import java.util.List;

public class MultiPartHelper {
    NetWorkResultListener resultListener;
    Activity activity;
    LocalBroadcastManager broadcastManager;

    public MultiPartHelper(Activity activity, String Url, String method, List<FileUpload> files, NetWorkResultListener netWorkResultListener)
    {
        broadcastManager = LocalBroadcastManager.getInstance(activity);
        broadcastManager.registerReceiver(receiver, new IntentFilter("Url"));

        this.resultListener=netWorkResultListener;

        this.activity=activity;
        uploadMultipleFile(Url,files);


    }
    void uploadMultipleFile(String Url,List<FileUpload> uploadList)

    {
        Intent intent = new Intent(activity, UploadService.class);
        intent.putExtra("url",Url);
        intent.putExtra("requestBody", (Serializable) uploadList);
        activity.startService(intent);
    }

    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String str = intent.getStringExtra("response");
                String url=intent.getStringExtra("url");
                // get all your data from intent and do what you want
                resultListener.onSuccess(str,url);
            }

            broadcastManager.unregisterReceiver(receiver);

        }
    };





}
