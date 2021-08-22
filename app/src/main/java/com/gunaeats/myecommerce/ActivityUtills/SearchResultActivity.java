package com.gunaeats.myecommerce.ActivityUtills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.gunaeats.myecommerce.AdapterUtills.MyRecyclerAdapter;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.model.categorymodel.products.Productlist;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;

import java.util.HashMap;

public class SearchResultActivity extends AppCompatActivity {

    EditText edtSearch;
    ImageView imgSearch;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        Toolbar toolbar = findViewById(R.id.idtoolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        edtSearch = (EditText) findViewById(R.id.id_edtserach);
        imgSearch = findViewById(R.id.idactionsearch);
        recyclerView = findViewById(R.id.recycler_view);

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtSearch.getText().toString().isEmpty()){
                    edtSearch.setError("Enter Product Name");
                }else {
                    callProductList();
                }
            }
        });

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    if (edtSearch.getText().toString().isEmpty()){
                        edtSearch.setError("Enter Product Name");
                    }else {
                        callProductList();
                    }

                    return true;
                }
                return false;
            }
        });
    }


    void callProductList(){
        HashMap<String,Object> params = new HashMap<>();
        params.put("action","Products_Search");
        params.put("searchtext",""+edtSearch.getText().toString());


        ProgressDialog progressDialog = new ProgressDialog(SearchResultActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        OkHttpRequest httpRequest = new OkHttpRequest(SearchResultActivity.this);
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                Log.e("PRODUCT_DATA",">>>> "+result);
                progressDialog.dismiss();

                try {
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    Productlist productlist = gson.fromJson(result,Productlist.class);
                    if (productlist.getStatus()==1){
                        // TODO: 6/25/2021  set adaptor
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(SearchResultActivity.this,RecyclerView.VERTICAL,false));
                        MyRecyclerAdapter  MyRecyclerAdapter = new MyRecyclerAdapter(SearchResultActivity.this, productlist);
                        recyclerView.setAdapter(MyRecyclerAdapter);
                    }
                } catch (Exception e) {
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