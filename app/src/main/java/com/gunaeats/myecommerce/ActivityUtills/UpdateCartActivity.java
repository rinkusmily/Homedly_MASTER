package com.gunaeats.myecommerce.ActivityUtills;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gunaeats.myecommerce.AdapterUtills.CartItemadapter;
import com.gunaeats.myecommerce.AdapterUtills.UpdateCartItemAdaptor;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.LocalCartModal;
import com.gunaeats.myecommerce.UAtils.Mycart;

import java.util.List;

public class UpdateCartActivity extends AppCompatActivity {

    UpdateCartItemAdaptor dealadapter;
    RecyclerView recycle_cart;
    ImageView iv_back;
    Button book_service;
    static  TextView tvTotalAmount;

    // Help remove to cart
    // cart order -- total order and 200 side me
    // order summery tersms remove and shedule date time contact detail cheek out
    // name address mobile pincoe landmark
    // my orders -- all aur confirm
    // order details comment
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cart);
        getSupportActionBar().hide();

        iv_back = findViewById(R.id.iv_back);
        recycle_cart = findViewById(R.id.recycle_cart);
        tvTotalAmount = findViewById(R.id.total_amount);

        book_service = findViewById(R.id.proceed);
        book_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mycart mycart = new Mycart(UpdateCartActivity.this);
                mycart.open();
                if (mycart.countproduct()>0){
                    Intent intent = new Intent(UpdateCartActivity.this, AddressActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(UpdateCartActivity.this, "Please Add Item From Cart", Toast.LENGTH_SHORT).show();
                }

            }
        });


        Mycart mycart = new Mycart(this);
        mycart.open();
        List<LocalCartModal> cartList = mycart.getAllProduct();
        tvTotalAmount.setText(getResources().getString(R.string.Rs2100)+" "+mycart.gettotalProductPrice());

        recycle_cart.setHasFixedSize(true);
        recycle_cart.setLayoutManager(new LinearLayoutManager(UpdateCartActivity.this, LinearLayoutManager.VERTICAL, false));
        dealadapter = new UpdateCartItemAdaptor(UpdateCartActivity.this, cartList,2);

        recycle_cart.setAdapter(dealadapter);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public  static void updateTotal(Context context){
        Mycart mycart = new Mycart(context);
        mycart.open();
        tvTotalAmount.setText(context.getResources().getString(R.string.Rs2100)+" "+mycart.gettotalProductPrice());
    }
}