package com.gunaeats.myecommerce.ActivityUtills;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gunaeats.myecommerce.MainActivity;
import com.gunaeats.myecommerce.R;

public class OrderSuccessActivity extends AppCompatActivity implements View.OnClickListener{

    Button jview_order;
    TextView jorder_id;
    String data;
    
    private MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_book_success);

        setTitle("Order Confirmed");
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    //    getSupportActionBar().setDisplayShowHomeEnabled(true);

        mainActivity = new MainActivity();
    
        data = getIntent().getStringExtra("orderid");
        jview_order = findViewById(R.id.view_order);
        jview_order.setOnClickListener(this);
        jorder_id= (TextView)findViewById(R.id.order_id);
        jorder_id.setText("Order Id : "+data);
        
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.view_order:
               // mainActivity.navView.setSelectedItemId(R.id.navigation_orders);
                Intent intent = new Intent(OrderSuccessActivity.this, MainActivity.class);
                intent.putExtra("FromReservation", "1");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OrderSuccessActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
