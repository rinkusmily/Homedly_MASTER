package com.gunaeats.myecommerce.ActivityUtills;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.util.Util;
import com.gunaeats.myecommerce.R;

import org.json.JSONObject;

public class DynamicWebActivity extends AppCompatActivity {

    private String mTitle;
    SwipeRefreshLayout swipeview;
    WebView myWebView;
    String title;
    String url;
    ProgressDialog progressDialog;
    TextView jtxt;
    ProgressBar jprogress;
    WebView jwebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_web);
      //  swipeview=(SwipeRefreshLayout)findViewById(R.id.swipeview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mTitle = getIntent().getStringExtra("title");
        if(mTitle.equalsIgnoreCase("TermsCondition")){
            setTitle("Term & Condition"); //&amp;
        }else {
            setTitle(mTitle);
        }
        url = getIntent().getStringExtra("url");
        jwebview = (WebView) findViewById(R.id.webview);
       // jtxt = (TextView) findViewById(R.id.txt);

        jprogress = (ProgressBar) findViewById(R.id.progress);

        /*FetchBanner();
        swipeview.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                FetchBanner();
            }
        });
        myWebView = (WebView) findViewById(R.id.webview);*/

        getData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return super.onSupportNavigateUp();
    }



  /*  private void FetchBanner() {
        if (Util.isConnected(DynamicWebActivity.this)) {

            swipeview.setRefreshing(true);
            String soap_action = SOAPConst.NAMESPACE + GlobalList.LoadPreferences(getApplicationContext(),"help_cooman_url");
            SoapObject request = new SoapObject(SOAPConst.NAMESPACE, GlobalList.LoadPreferences(getApplicationContext(),"help_cooman_url"));
            SoapSerializationEnvelope envelope = SOAPTask.getSoapSerializationEnvelope(request);
            Log.e("GetRecord", "" + request);
            HttpTransportSE ht = SOAPTask.getHttpTransportSE();
            @SuppressLint("HandlerLeak") Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    String response = String.valueOf(msg.obj);
                    Log.e("GetRecord", "" + response);

                    swipeview.setRefreshing(false);
                    try {
                        JSONArray jsonArray=new JSONArray(response);
                        JSONObject jsonObject=jsonArray.getJSONObject(0);
                        String data=jsonObject.getString("description");
                        String encodedHtml = Base64.encodeToString(data.getBytes(),
                                Base64.NO_PADDING);

                        WebSettings webSettings = myWebView.getSettings();
                        webSettings.setJavaScriptEnabled(true);

                        myWebView.loadData(encodedHtml, "text/html", "base64");
                    } catch (Throwable e) {
                        Log.e("GetRecord",""+e);
                    }
                    Log.e("data", response);
                }
            };
            new SOAPTask(ht, envelope, soap_action, handler).execute();
        } else {

        }
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData() {}

    public void showDialog() {

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public void closeDialog() {
        progressDialog.dismiss();
    }
}
