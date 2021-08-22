package com.gunaeats.myecommerce;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gunaeats.myecommerce.ActivityUtills.OtpActivity;
import com.gunaeats.myecommerce.ActivityUtills.ProductListActivity;
import com.gunaeats.myecommerce.AdapterUtills.MyRecyclerAdapter;
import com.gunaeats.myecommerce.model.categorymodel.products.Productlist;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    Button btn_sign_in;
    EditText edtMobileNo;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        initUI();
    }

    private void initUI() {
        edtMobileNo = findViewById(R.id.et_user_name);
        btn_sign_in= findViewById(R.id.btn_sign_in);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtMobileNo.getText().toString().length()<10){
                    edtMobileNo.setError("Enter Valid Phone Number");
                }else {
                    callProductList();
                }


            }
        });

    }



    void callProductList(){

      final  ProgressDialog progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(true);
        progressDialog.show();
        HashMap<String,Object> params = new HashMap<>();
        params.put("action","sendOtp");
        params.put("mobileno",edtMobileNo.getText().toString());


        OkHttpRequest httpRequest = new OkHttpRequest(mContext);
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                Log.e("PRODUCT_DATA",">>>> "+result);

                progressDialog.dismiss();
                try {
                    JSONObject  jsonObject = new JSONObject(result);
                    if (jsonObject.getInt("status") == 1) {
                        Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
                        intent.putExtra("mobieNo",edtMobileNo.getText().toString());
                        startActivity(intent);
                        finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }

            @Override
            public void onError(String error) {
                progressDialog.dismiss();
            }
        });
    }

}