package com.gunaeats.myecommerce.serverconnection;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpRequest
{
    Context context;
    Context activity ;
    Request request ;
    OkHttpClient okHttpClient ;

    ProgressDialog progressDialog ;
    public OkHttpRequest(Context activity)
    {
        this.activity = activity;
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.MINUTES)
                .writeTimeout(50, TimeUnit.MINUTES)
                .readTimeout(50, TimeUnit.MINUTES)
                .build();
    }

    public void getResponse(Map<String , Object> param , final ServerRespondingListener serverRespondingListener) {
        System.out.println("------SENDVALUE----" + param);

        request = new Request.Builder()
                .url(Constant.BASE_URL)
                .post(getMultiPartRrquest(param))
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                try {
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            serverRespondingListener.onError(e.getMessage());
                        }
                    });
                } catch (Exception e1) {
                    e1.printStackTrace();
                }


            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String myResponse = response.body().string();
                System.out.println("------RESPONSEE----"+myResponse);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        serverRespondingListener.onResponse(myResponse);
                    }
                });


            }


        });
    }


    public MultipartBody getMultiPartRrquest(Map<String , Object> param)
    {
        MultipartBody.Builder multipartBody = new MultipartBody.Builder();



        Set<Map.Entry<String, Object>> keyValuePairList = param.entrySet();

        Iterator<Map.Entry<String,Object>> keyValuePair = keyValuePairList.iterator();
        final MediaType MEDIA_TYPE_PNG = MediaType.get("image/*");

        while (keyValuePair.hasNext())
        {
            Map.Entry<String,Object> keyValue = keyValuePair.next();

            if (keyValue.getValue() instanceof File)
            {
                File file = (File) keyValue.getValue();
                multipartBody.addFormDataPart(keyValue.getKey(), file.getName(), RequestBody.create(MEDIA_TYPE_PNG, file));

            }
            else
            {
                multipartBody.addFormDataPart(keyValue.getKey() , keyValue.getValue().toString());
            }
        }
        multipartBody.setType(MultipartBody.FORM);
        MultipartBody multipart = multipartBody.build();
        return multipart ;
    }

}