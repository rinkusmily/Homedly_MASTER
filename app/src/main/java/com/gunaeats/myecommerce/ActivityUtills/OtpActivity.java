package com.gunaeats.myecommerce.ActivityUtills;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.gunaeats.myecommerce.LoginActivity;
import com.gunaeats.myecommerce.MainActivity;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.UserSession;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;
import com.gunaeats.myecommerce.utils.SMSReceiver;
import com.gunaeats.myecommerce.utils.SmsListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class OtpActivity extends AppCompatActivity {

    Context mContext;
    Button btn_verify_otp;
    String mobileNo;
    TextView tvTimer;
    EditText EdtOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_otp);
        mContext = this;
        setTitle("SIGN-IN");
        mobileNo = getIntent().getStringExtra("mobieNo");

        initUI();



       SMSReceiver.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String messageText) {
                EdtOTP.setText(messageText);
            }
        });




        cowndownimer();
    }

    private void initUI() {
        tvTimer = findViewById(R.id.timer);
        EdtOTP = findViewById(R.id.inputOtp);
        btn_verify_otp= findViewById(R.id.btn_verify_otp);
        btn_verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (EdtOTP.getText().toString().isEmpty()){
                    Toast.makeText(mContext, "Please Enter OTP", Toast.LENGTH_SHORT).show();
                }else {

                    verifyOTP();
                }

            }
        });

        tvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resentOTP();
            }
        });
    }

    void cowndownimer(){
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {



                tvTimer.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                tvTimer.setText(" Resend Otp");
            }

        }.start();

    }



    void verifyOTP(){

        final ProgressDialog progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(true);
        progressDialog.show();

        HashMap<String,Object> params = new HashMap<>();
        params.put("action","verifyOtp");
        params.put("otp",EdtOTP.getText().toString());
        params.put("mobileno",mobileNo);


        OkHttpRequest httpRequest = new OkHttpRequest(mContext);
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                Log.e("PRODUCT_DATA",">>>> "+result);

                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.getInt("status") == 1) {
                        JSONObject responsobject = jsonObject.getJSONObject("response");

                        UserSession.getInstance(mContext).writePrefs(UserSession.PREFS_USER_MOBILE,mobileNo);
                        UserSession.getInstance(mContext).writePrefs(UserSession.PREFS_USER_ID,responsobject.getString("id"));

                        Intent intent = new Intent(OtpActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(mContext, "Try again...", Toast.LENGTH_SHORT).show();
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



    void resentOTP(){

        final  ProgressDialog progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(true);
        progressDialog.show();

        HashMap<String,Object> params = new HashMap<>();
        params.put("action","sendOtp");
        params.put("mobileno",mobileNo);


        OkHttpRequest httpRequest = new OkHttpRequest(mContext);
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                Log.e("PRODUCT_DATA",">>>> "+result);

                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.getInt("status") == 1) {

                        SMSReceiver.bindListener(new SmsListener() {
                            @Override
                            public void messageReceived(String messageText) {
                                EdtOTP.setText(messageText);
                            }
                        });

                        cowndownimer();
                    }else {
                        Toast.makeText(mContext, "Try again...", Toast.LENGTH_SHORT).show();
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