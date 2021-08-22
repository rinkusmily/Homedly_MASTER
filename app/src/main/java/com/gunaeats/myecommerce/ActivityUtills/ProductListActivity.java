package com.gunaeats.myecommerce.ActivityUtills;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gunaeats.myecommerce.AdapterUtills.MyRecyclerAdapter;
import com.gunaeats.myecommerce.AdapterUtills.SubCategoryAdapter;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.model.categorymodel.products.Productlist;
import com.gunaeats.myecommerce.model.categorymodel.subcategory.Subcategorylist;
import com.gunaeats.myecommerce.pojomodel.Category;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductListActivity extends AppCompatActivity {
    ArrayList<Category> arrayList = new ArrayList<>();
    RecyclerView recycler_view;
    LinearLayout norecord;
    com.gunaeats.myecommerce.AdapterUtills.MyRecyclerAdapter MyRecyclerAdapter;
    Dialog dialogTransparent;
    SwipeRefreshLayout swipe_view;
    Context mContext;
    String categoryID;
    String SubcategoryId;
    String SubcategoryName;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mContext = this;
        categoryID = getIntent().getStringExtra("category_id");
        SubcategoryId = getIntent().getStringExtra("subcategory_id");
        SubcategoryName = getIntent().getStringExtra("subcategory_name");

        getSupportActionBar().setTitle(SubcategoryName);
        norecord=(LinearLayout)findViewById(R.id.norecord);
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);


        callProductList();



        swipe_view= (SwipeRefreshLayout) findViewById(R.id.swipe_view);
        swipe_view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                callProductList();
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                MyRecyclerAdapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                try {
                    MyRecyclerAdapter.filter(newText);

                } catch (Throwable e) {

                }
                return false;
            }
        });
        return true;
    }


    // TODO: 6/25/2021  get all product

    void callProductList(){
        ProgressDialog progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        HashMap<String,Object> params = new HashMap<>();
        params.put("action","Products");
        params.put("category_id",categoryID);
        params.put("subcategory_id",SubcategoryId);

        OkHttpRequest httpRequest = new OkHttpRequest(mContext);
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                Log.e("PRODUCT_DATA",">>>> "+result);
                swipe_view.setRefreshing(false);
                progressDialog.dismiss();
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Productlist productlist = gson.fromJson(result,Productlist.class);
                if (productlist.getStatus()==1){
                    // TODO: 6/25/2021  set adaptor

                    recycler_view.setHasFixedSize(true);
                    recycler_view.setLayoutManager(new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false));
                    MyRecyclerAdapter = new MyRecyclerAdapter(ProductListActivity.this, productlist);

                    recycler_view.setAdapter(MyRecyclerAdapter);


                }
            }

            @Override
            public void onError(String error) {
                progressDialog.dismiss();
            }
        });
    }



}