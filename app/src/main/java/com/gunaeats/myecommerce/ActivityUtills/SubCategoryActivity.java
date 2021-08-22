package com.gunaeats.myecommerce.ActivityUtills;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gunaeats.myecommerce.AdapterUtills.SubCategoryAdapter;
import com.gunaeats.myecommerce.HomeCatAdapter;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.model.categorymodel.CategoryModel;
import com.gunaeats.myecommerce.model.categorymodel.subcategory.Subcategorylist;
import com.gunaeats.myecommerce.pojomodel.ListItem;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;
import com.gunaeats.myecommerce.utils.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.HashMap;

public class SubCategoryActivity extends AppCompatActivity {
    ArrayList<ListItem> arrayList = new ArrayList<>();
    RecyclerView recycler_view;
    String sub_cat_id,cat_name;
    LinearLayout norecord;

    Dialog dialogTransparent;
    SwipeRefreshLayout swipe_view;
    SubCategoryAdapter laestServiceAdapter;

    String categoryId;
    String categoryName;
    Context mContext;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);

        mContext = this;
        categoryId = getIntent().getStringExtra("category_id");
        categoryName = getIntent().getStringExtra("category_name");

        toolbar.setTitle(categoryName);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        norecord=(LinearLayout)findViewById(R.id.norecord);
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);


        callSubCategory();


        swipe_view= (SwipeRefreshLayout) findViewById(R.id.swipe_view);
        swipe_view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe_view.setRefreshing(false);
                callSubCategory();


            }
        });
    }





    void callSubCategory(){
        ProgressDialog progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        HashMap<String,Object> params = new HashMap<>();
        params.put("action","SubCategory");
        params.put("category_id",categoryId);

        OkHttpRequest httpRequest = new OkHttpRequest(mContext);
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                Log.e("SUBCAREGORYDATE",">>>> "+result);
                progressDialog.dismiss();
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Subcategorylist subcategorylist = gson.fromJson(result,Subcategorylist.class);
                if (subcategorylist.getStatus()==1){
                    // TODO: 6/25/2021  set adaptor

                    recycler_view.setHasFixedSize(true);
                    recycler_view.setLayoutManager(new GridLayoutManager(mContext,3));
                    laestServiceAdapter = new SubCategoryAdapter(SubCategoryActivity.this, subcategorylist,1);
                    recycler_view.setAdapter(laestServiceAdapter);
                }
            }

            @Override
            public void onError(String error) {
                progressDialog.dismiss();
            }
        });
    }

}