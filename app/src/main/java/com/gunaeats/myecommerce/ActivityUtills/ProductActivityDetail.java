package com.gunaeats.myecommerce.ActivityUtills;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gunaeats.myecommerce.AdapterUtills.MyRecyclerAdapter;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.Mycart;
import com.gunaeats.myecommerce.model.categorymodel.products.Image;
import com.gunaeats.myecommerce.model.categorymodel.products.Productlist;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;

import java.util.HashMap;
import java.util.List;

import static com.gunaeats.myecommerce.serverconnection.Constant.PRODUCT_IMAGE_URL;

public class ProductActivityDetail extends AppCompatActivity {

    Button proceed;
    String productID;
    Context mContext;
    ImageView imgProduct;
   TextView ProductName;
   TextView tvProductDescription;
   TextView tvProductPrice;
   Button btndecriment;
   TextView tvQuantity;
   Button btnIncriment;
   AppCompatButton btnAddTocart;

   TextView tvbedgeText;
   TextView tvTotalCartPrice;

   double productPrice;
   double calculatedPrice=0.0;


   String strproductimage;
   String strproductname;
   String strproductdescription;
   String strproductshortDescription;
   Mycart mycart;
    SliderLayout sliderLayout;
    int banner[] ={R.drawable.banner,R.drawable.banner_2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mContext = this;
        mycart =  new Mycart(mContext);

        productID = getIntent().getStringExtra("product_id");
        toolbar.setTitle(getIntent().getStringExtra("subcategory_name"));
        //productID = getIntent().getStringExtra("subcategory_name");

        imgProduct = findViewById(R.id.backdrop);
        ProductName = findViewById(R.id.id_productName);
        tvProductDescription = findViewById(R.id.id_product_description);
        tvProductPrice = findViewById(R.id.c_price);
        btndecriment = findViewById(R.id.minus_btn);
        tvQuantity = findViewById(R.id.inc_dec_tv);
        btnIncriment = findViewById(R.id.plus_btn);
        btnAddTocart = findViewById(R.id.add_to_cart);
        tvbedgeText = findViewById(R.id.badge);
        tvTotalCartPrice = findViewById(R.id.totalc_price);

        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        sliderLayout.setDuration(10000l);

        proceed = findViewById(R.id.proceed);

        mycart.open();
        tvbedgeText.setText(""+mycart.countproduct());
        tvTotalCartPrice.setText(""+mycart.gettotalProductPrice());
        mycart.close();




        btndecriment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number =  tvQuantity.getText().toString();
                int val = Integer.parseInt(number);
                if (val>1){
                    val = val - 1;
                    tvQuantity.setText(""+val);
                    calculatedPrice =0.0;
                    calculatedPrice = productPrice*val;
                    tvProductPrice.setText(getResources().getString(R.string.Rs2100)+" "+calculatedPrice);

                }
            }
        });

        btnIncriment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number =  tvQuantity.getText().toString();
                int val = Integer.parseInt(number);
                val = val +1;
                Log.d("TAG", "onClick: "+val);

                calculatedPrice =0.0;
                calculatedPrice = productPrice*val;
                tvProductPrice.setText(getResources().getString(R.string.Rs2100)+" "+calculatedPrice);

                tvQuantity.setText(""+val);
            }
        });


        btnAddTocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mycart.open();
                if (mycart.checkAvailableProduct(productID)==1){
                    // TODO: 6/25/2021  update Product
                    mycart.updateQuantity(productID,tvQuantity.getText().toString());
                    Toast.makeText(mContext, "yes the product is Updated", Toast.LENGTH_SHORT).show();

                }else {
                    // TODO: 6/25/2021  insert Product
                    mycart.insertproduct(productID,strproductname,strproductimage,""+productPrice,tvQuantity.getText().toString(),strproductdescription,strproductshortDescription);
                    Toast.makeText(mContext, "yes the product is added", Toast.LENGTH_SHORT).show();
                }

                tvbedgeText.setText(""+mycart.countproduct());
                tvTotalCartPrice.setText(""+mycart.gettotalProductPrice());



            }
        });




        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                mycart.open();
                if (mycart.countproduct()>0){
                    Intent intent = new Intent(ProductActivityDetail.this,UpdateCartActivity.class);
                    startActivity(intent); 
                }else {
                    Toast.makeText(mContext, "Please Add Product to cart", Toast.LENGTH_SHORT).show();
                }
               
            }
        });


        callSingleProduct();


    }


    // TODO: 6/25/2021  call product to productid

    void callSingleProduct(){
        HashMap<String,Object> params = new HashMap<>();
        params.put("action","SingleProduct");
        params.put("product_id",productID);
        params.put("size_id","");

        OkHttpRequest httpRequest = new OkHttpRequest(mContext);
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                Log.e("PRODUCT_DATA",">>>> "+result);


                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Productlist productlist = gson.fromJson(result,Productlist.class);
                if (productlist.getStatus()==1){
                    // TODO: 6/25/2021  set adaptor

                   strproductimage = productlist.getResponse().get(0).getBaseUrl()+""+productlist.getResponse().get(0).getThumbnailImage();
                    Log.e("IMAGEURLLL",">>>> "+strproductimage);
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.no_image);
                    requestOptions.error(R.drawable.no_image);
                    Glide.with(mContext)
                            .setDefaultRequestOptions(requestOptions)
                            .load(strproductimage).into(imgProduct);

                    ProductName.setText(productlist.getResponse().get(0).getProdTitle());
                    tvProductDescription.setText(productlist.getResponse().get(0).getProdDesc());
                    tvProductPrice.setText(getResources().getString(R.string.Rs2100)+" "+productlist.getResponse().get(0).getProdPrice());
                    productPrice = Double.parseDouble(productlist.getResponse().get(0).getProdPrice());

                    strproductname = productlist.getResponse().get(0).getProdTitle();
                    strproductdescription = productlist.getResponse().get(0).getProdDesc();
                    strproductshortDescription = productlist.getResponse().get(0).getProdShortDesc();


                    SetSliderLayout(productlist.getResponse().get(0).getImages());
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }
    private void SetSliderLayout(List<Image> imagelist) {


        for (int i = 0; i < imagelist.size(); i++) {
            String imageurl = PRODUCT_IMAGE_URL+imagelist.get(0).getImage();
            DefaultSliderView defaultSliderView = new DefaultSliderView(mContext);
            defaultSliderView.image(imageurl)
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            sliderLayout.addSlider(defaultSliderView);
        }

        sliderLayout.stopAutoCycle();
        sliderLayout.setCurrentPosition(0);
        //sliderLayout.movePrevPosition(false);
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.ZoomOutSlide);

    }

}