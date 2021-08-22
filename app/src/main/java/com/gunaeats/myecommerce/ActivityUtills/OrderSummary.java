package com.gunaeats.myecommerce.ActivityUtills;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gunaeats.myecommerce.AdapterUtills.CartAdapter;
import com.gunaeats.myecommerce.MainActivity;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.pojomodel.CartModel;
import com.gunaeats.myecommerce.utils.QuantityListner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class OrderSummary extends AppCompatActivity implements View.OnClickListener, QuantityListner {

    ProgressDialog progressDialog;

    RecyclerView jrecycle_cart;
    List<CartModel> cartModels= new ArrayList<>();
    CartAdapter cartAdapter;
    TextView jtotal_amount,jschdule_date_time,jmobileno,jlocation,jaddress,jaddress_type,jopen_close,jservice_cost;
    int total=00;
    Button jconfirm_order,jbook_service,jsubmit_coupon,jremove_coupon;
    CheckBox jterms_box;
    String tcd_id,remark,date,time;
    //AddressModel addressModel;
    ImageView jaddress_type_img;
    LinearLayout norecord,jhave_coupon,jcoupon_layout,jll_delivery_charge,jterm_and_condition;
    RelativeLayout jmain_rl;
    ProgressBar jprogress;
    Dialog dialogTransparent;
    EditText jcoupon;
    String coupon;
    int delevery_cost=0,IsPaymentFirst = -1,wallet_amount,orderAmount=0,difference;
    View jdelivery_view;

    String TAG="OrderSummary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Order Summary");
        init();


        tcd_id = getIntent().getStringExtra("tcd_id");
        remark = getIntent().getStringExtra("remark");
        date = getIntent().getStringExtra("schdule_date");
        time = getIntent().getStringExtra("schedule_time");
        jschdule_date_time.setText(date+" | "+time);
        jlocation.setText("near bapat coraha Guna MP");
        jaddress.setText("near bapat coraha Guna MP");

        if(coupon != null && !coupon.isEmpty()){

            jsubmit_coupon.setVisibility(View.GONE);
            jremove_coupon.setVisibility(View.VISIBLE);
            jcoupon.setText(coupon+" (applied)");
            jcoupon.setEnabled(false);
        }else {
            coupon="";
        }


            jaddress_type.setText("Home");
            jaddress_type_img.setImageResource(R.drawable.home_green);

     }

     private void init(){

         jdelivery_view = (View) findViewById(R.id.delivery_view);
         jterm_and_condition = (LinearLayout) findViewById(R.id.term_and_condition);
         jprogress = (ProgressBar) findViewById(R.id.progress);
         jmain_rl = (RelativeLayout) findViewById(R.id.main_rl);
         norecord= (LinearLayout) findViewById(R.id.norecord);
         jhave_coupon = (LinearLayout) findViewById(R.id.have_coupon);
         jll_delivery_charge = (LinearLayout) findViewById(R.id.ll_delivery_charge);
         jopen_close = (TextView) findViewById(R.id.open_close);
         jservice_cost = (TextView) findViewById(R.id.service_cost);
         jcoupon_layout = (LinearLayout) findViewById(R.id.coupon_layout);
         jcoupon = (EditText) findViewById(R.id.coupon);
         jsubmit_coupon = (Button) findViewById(R.id.submit_coupon);
         jremove_coupon = (Button) findViewById(R.id.remove_coupon);
         jbook_service = (Button) findViewById(R.id.book_service);
         jrecycle_cart = (RecyclerView) findViewById(R.id.recycle_cart);
         RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
         jrecycle_cart.setLayoutManager(mLayoutManager);
         jrecycle_cart.setItemAnimator(new DefaultItemAnimator());
         jtotal_amount = (TextView) findViewById(R.id.total_amout);
         jschdule_date_time =(TextView) findViewById(R.id.schdule_date_time);
         jconfirm_order = (Button) findViewById(R.id.confirm_order);
         jterms_box = (CheckBox) findViewById(R.id.terms_box);
         jmobileno = (TextView)findViewById(R.id.mobileno);
         jlocation = (TextView) findViewById(R.id.location);
         jaddress = (TextView) findViewById(R.id.address);
         jaddress_type_img = (ImageView) findViewById(R.id.address_type_img);
         jaddress_type = (TextView) findViewById(R.id.address_type);
         jconfirm_order.setOnClickListener(this);
         jbook_service.setOnClickListener(this);
         jhave_coupon.setOnClickListener(this);
         jsubmit_coupon.setOnClickListener(this);
         jremove_coupon.setOnClickListener(this);
         jterm_and_condition.setOnClickListener(this);

         showCartItem();
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    public void showDialog() {

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    private void showCartItem(){


        jmain_rl.setVisibility(View.VISIBLE);
        jconfirm_order.setVisibility(View.VISIBLE);
        norecord.setVisibility(View.GONE);
        cartAdapter = new CartAdapter(cartModels, OrderSummary.this,this);
        jrecycle_cart.setAdapter(cartAdapter);
        setTotalPrice();

    }

    private void setTotalPrice(){

        int mPriceItemsPrice = 0;
        orderAmount=0;

            jtotal_amount.setText(getResources().getString(R.string.Rs)+" "+"200");

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(cartAdapter != null) {
            cartAdapter.notifyDataSetChanged();
            setTotalPrice();
        }
    }


    public void closeDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.confirm_order:

                insertOrder();


                break;

            case R.id.book_service:
                startActivity(new Intent(OrderSummary.this,MainActivity.class));
                finish();
                break;

            case R.id.submit_coupon:
                if(!TextUtils.isEmpty(jcoupon.getText().toString())){
                   // checkCouponValid();
                }else {
                    Toast.makeText(this, "Enter Coupon Code", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.remove_coupon:

                jcoupon.setText("");
                jcoupon.setEnabled(true);
                jsubmit_coupon.setVisibility(View.VISIBLE);
                jremove_coupon.setVisibility(View.GONE);
                break;


            case R.id.have_coupon:

                if(jcoupon_layout.isShown()){
                    jcoupon_layout.setVisibility(View.GONE);
                    jopen_close.setText("+");
                }else {
                    jcoupon_layout.setVisibility(View.VISIBLE);
                    jopen_close.setText("-");
                }

                break;

                case R.id.term_and_condition:
                    Intent intent = new Intent(this, DynamicWebActivity.class);
                    intent.putExtra("title","TermsCondition");
                    intent.putExtra("url","Other_Terms_And_Condition");
                    startActivity(intent);
                    break;
        }
    }

    @Override
    public void onQuantityChanged() {
        setTotalPrice();
    }

    @Override
    public void onDeleteClick(int pos) {

        showCartItem();
    }

    private void insertOrder() {
        startActivity(new Intent(OrderSummary.this,AddressActivity.class));
    }

    private void getDeleveryCost(){


    }


    public String isNullReturnBlank (String value) {
        if(value == null || value.isEmpty()){
            return "";
        }else {
            return value;
        }
    }


    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)  getSystemService(INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view =getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    /**
     * This function prepares the data for payment and launches payumoney plug n play sdk
     */



    public static String hashCal(String str) {
        byte[] hashseq = str.getBytes();
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
            algorithm.reset();
            algorithm.update(hashseq);
            byte messageDigest[] = algorithm.digest();
            for (byte aMessageDigest : messageDigest) {
                String hex = Integer.toHexString(0xFF & aMessageDigest);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException ignored) {
        }
        return hexString.toString();
    }

    /**
     * This function sets the layout for activity
     */




}
