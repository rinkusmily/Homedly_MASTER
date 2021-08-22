package com.gunaeats.myecommerce.ActivityUtills;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gunaeats.myecommerce.AdapterUtills.CompleteOrderItemAdaptor;
import com.gunaeats.myecommerce.AdapterUtills.OrderAdapter;
import com.gunaeats.myecommerce.MainActivity;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.UserSession;
import com.gunaeats.myecommerce.model.categorymodel.order.OrderPojo;
import com.gunaeats.myecommerce.model.categorymodel.order.Response;
import com.gunaeats.myecommerce.pojomodel.OrderCancel;
import com.gunaeats.myecommerce.pojomodel.OrderDetailView;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;

import org.w3c.dom.Text;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewOrderDetails extends AppCompatActivity {

    Context mContext;
   TextView tvOrderId;
   TextView tvOrderDate;
   TextView tvOrderStatus;
   TextView tvTtalAmount;
   ProgressDialog progressDialog;
   RecyclerView recyclerVieworder;
    int finalamount = 0;
    String OrderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_order_details);
        setTitle("Order Details");
        mContext = this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        OrderId = getIntent().getStringExtra("OrderID");
        initialize();

        getHistoryData();

    }


    void initialize(){

        tvOrderId = findViewById(R.id.orderid);
        tvOrderDate = findViewById(R.id.date);
        tvOrderStatus = findViewById(R.id.orderstatus);
        tvTtalAmount = findViewById(R.id.TotalAmount);
        recyclerVieworder = findViewById(R.id.order_rec);
    }

    public void showDialog() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public void closeDialog() {
        progressDialog.dismiss();
    }


    void getHistoryData() {
        showDialog();
        Map<String, Object> params = new HashMap<>();
        params.put("action", "singleorderhistory");
        params.put("user_id", UserSession.getInstance(mContext).readPrefs(UserSession.PREFS_USER_ID));
        params.put("booked_id", OrderId);
        OkHttpRequest httpRequest = new OkHttpRequest(mContext);
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                closeDialog();
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                OrderPojo myOrder = gson.fromJson(result, OrderPojo.class);

                tvOrderId.setText(myOrder.getResponse().get(0).getBookedId());
                tvOrderDate.setText(myOrder.getResponse().get(0).getDate());
                tvTtalAmount.setText(myOrder.getResponse().get(0).getTotal());

                if(myOrder.getResponse().get(0).getConfirmStatus()==2){
                    tvOrderStatus.setVisibility(View.VISIBLE);
                    tvOrderStatus.setText("Completed");
                }else {
                    tvOrderStatus.setVisibility(View.VISIBLE);
                    tvOrderStatus.setText("Pending");
                }


                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false);
                recyclerVieworder.setLayoutManager(layoutManager);
                CompleteOrderItemAdaptor adaptor = new CompleteOrderItemAdaptor(mContext,myOrder.getResponse().get(0).getOrderedProducts().get(0).getProducts());
                recyclerVieworder.setAdapter(adaptor);
                adaptor.notifyDataSetChanged();

            }

            @Override
            public void onError(String error) {
                Toast.makeText(mContext, "Please Check your Internet Connection!", Toast.LENGTH_SHORT).show();
                closeDialog();
            }
        });

    }

}
