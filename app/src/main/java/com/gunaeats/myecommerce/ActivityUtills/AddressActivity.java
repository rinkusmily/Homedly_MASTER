package com.gunaeats.myecommerce.ActivityUtills;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.JsonObject;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.LocalCartModal;
import com.gunaeats.myecommerce.UAtils.Mycart;
import com.gunaeats.myecommerce.UAtils.UserSession;
import com.gunaeats.myecommerce.pojomodel.CartModel;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressActivity extends AppCompatActivity {

    Context mContext;
    Button confirm_order;
    EditText edtName;
    EditText edtAddressType;
    EditText edtHouseNo;
    EditText edtSocity;
    EditText dtLandMark;
    EditText edtPinCode;
    EditText edtPhone;
    Spinner spinnerCity;
    EditText edtCity;

    String[] country = {"Guna"};
    String city;

    String addressID;

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        mContext = this;
      Toolbar toolbar =  findViewById(R.id.toolbar);
      toolbar.setNavigationOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });

        edtName = findViewById(R.id.id_nameaddess);
        edtPhone = findViewById(R.id.id_phoneno);
        edtAddressType = findViewById(R.id.id_nametype);
        edtHouseNo = findViewById(R.id.id_namehouseno);
        edtSocity = findViewById(R.id.id_namesocity);
        dtLandMark = findViewById(R.id.s_addresslandmark);
        edtPinCode = findViewById(R.id.id_addresspincode);
        spinnerCity = findViewById(R.id.sparea);
        edtCity = findViewById(R.id.s_city);
        edtPhone.setText(UserSession.getInstance(mContext).readPrefs(UserSession.PREFS_USER_MOBILE));
        confirm_order = findViewById(R.id.confirm_order);




        confirm_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validation()) {
                    return;
                }
                String name = edtName.getText().toString();
                String mobileNo = edtPhone.getText().toString();
                String address = edtAddressType.getText().toString();
                String houseNo = edtHouseNo.getText().toString();
                String socity = edtSocity.getText().toString();
                String ladmark = dtLandMark.getText().toString();
                String pincode = edtPinCode.getText().toString();
                city = edtCity.getText().toString();
                Map<String, Object> params = new HashMap<>();

                params.put("action", "addPlaceOrderAddress");
                params.put("name", name);
                params.put("mobileno", mobileNo);
                params.put("address", address);
                params.put("houseno", houseNo);
                params.put("society", socity);
                params.put("landmark", ladmark);
                params.put("zipcode", pincode);
                params.put("city", city);
                params.put("userid",UserSession.getInstance(mContext).readPrefs(UserSession.PREFS_USER_ID));

                progressDialog = new ProgressDialog(mContext);
                progressDialog.setMessage("Order Placing Please Wait...");
                progressDialog.setCancelable(true);
                progressDialog.show();

                saveorEditAddress(params);


            }
        });
        getAddress();
    }

    boolean validation() {
        boolean valid = true;
        String name = edtName.getText().toString();
        String mobileNo = edtPhone.getText().toString();
        String address = edtAddressType.getText().toString();
        String houseNo = edtHouseNo.getText().toString();
        String socity = edtSocity.getText().toString();
        String ladmark = dtLandMark.getText().toString();
        String pincode = edtPinCode.getText().toString();

        if (name.isEmpty()) {
            edtName.setError("Enter Name");
            valid = false;
        } else {
            edtName.setError(null);
        }

        if (mobileNo.isEmpty()) {
            edtPhone.setError("Enter Phone Number");
            valid = false;
        } else {
            edtPhone.setError(null);
        }

        if (address.isEmpty()) {
            edtAddressType.setError("Enter Address");
            valid = false;
        } else {
            edtAddressType.setError(null);
        }
        if (houseNo.isEmpty()) {
            edtHouseNo.setError("Enter House Number");
            valid = false;
        } else {
            edtHouseNo.setError(null);
        }
        if (socity.isEmpty()) {
            edtSocity.setError("Enter Society");
            valid = false;
        } else {
            edtSocity.setError(null);
        }

       /* if (ladmark.isEmpty()){
            dtLandMark.setError("Enter LandMark");
            valid = false;
        }else {
            dtLandMark.setError(null);
        }*/

        if (pincode.isEmpty()) {
            edtPinCode.setError("Enter Pin code");
            valid = false;
        } else {
            edtPinCode.setError(null);
        }
        return valid;
    }


    void saveorEditAddress(Map<String, Object> params) {
        OkHttpRequest httpRequest = new OkHttpRequest(mContext);
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
               // {"status":1,"message":"Address has been added successfully"}

                placeOrder();

/*
                try {
                    JSONObject object = new JSONObject(result);
                    if (object.getInt("status")==1){



                    }else {
                        Toast.makeText(mContext, "Address Not Added Please try again!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
*/

            }

            @Override
            public void onError(String error) {
                progressDialog.dismiss();
            }
        });

    }

   void getAddress(){

        OkHttpRequest httpRequest = new OkHttpRequest(mContext);
        Map<String,Object> params = new HashMap<>();
        params.put("action","getPlaceOrderAddress");
        params.put("userid",UserSession.getInstance(mContext).readPrefs(UserSession.PREFS_USER_ID));

        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {

               /*{"status":1,"response":{"address_id":"1","user_id":"1","user_name":"parag",
               "user_mobile":"7878454512","address":"indore","zipcode":"452002",
               "landmark":"landmark","city":"indore","houseno":"195","society":"shekhar
central"},"message":"Get user address list!"}*/
                try {
                    JSONObject object = new JSONObject(result);
                    if (object.getInt("status")==1){

                        JSONObject response = object.getJSONObject("response");

                        addressID = response.getString("address_id");
                        edtName.setText(response.optString("user_name"));
                        edtPhone.setText(response.optString("user_mobile"));
                        edtHouseNo.setText(response.optString("houseno"));
                        edtAddressType.setText(response.optString("address"));
                        edtSocity.setText(response.optString("society"));
                        edtPinCode.setText(response.optString("zipcode"));
                        dtLandMark.setText(response.optString("landmark"));

                        for (int i = 0; i <country.length ; i++) {
                            if (country[i].equalsIgnoreCase(response.optString("city"))){
                                setCitySpinner(i);
                                break;
                            }
                        }
                    }else {
                        setCitySpinner(0);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(String error) {

            }
        });
    }

     void setCitySpinner(int position){
         ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
         aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         //Setting the ArrayAdapter data on the Spinner
         spinnerCity.setAdapter(aa);
         spinnerCity.setSelection(position);
         aa.notifyDataSetChanged();

         spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 city = country[position];
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });
     }


     void placeOrder(){

         Mycart mycart = new Mycart(mContext);
         mycart.open();
      List<LocalCartModal> cartitemLst = mycart.getAllProduct();


         JSONArray jsonArray = new JSONArray();
         for (int i = 0; i <cartitemLst.size() ; i++) {


             try {
                 JSONObject object = new JSONObject();
                 object.put("product_id",cartitemLst.get(i).getId());
                 object.put("qty",cartitemLst.get(i).getQuantity());
                 object.put("price",cartitemLst.get(i).getPrice());
                 double itemprice = Double.parseDouble(cartitemLst.get(i).getQuantity()) * Double.parseDouble(cartitemLst.get(i).getPrice());
                 object.put("totalprice",mycart.gettotalProductPrice());
                 jsonArray.put(object);
             } catch (JSONException e) {
                 e.printStackTrace();
             }

         }


         OkHttpRequest httpRequest = new OkHttpRequest(mContext);

         String name = edtName.getText().toString();
         String mobileNo = edtPhone.getText().toString();
         String address = edtAddressType.getText().toString();
         String houseNo = edtHouseNo.getText().toString();
         String socity = edtSocity.getText().toString();
         String ladmark = dtLandMark.getText().toString();
         String pincode = edtPinCode.getText().toString();
//product_data : [{"product_id":"1","qty":"3","price":"120","totalprice":"360"}]
         Map<String,Object> params = new HashMap<>();
         params.put("action","bookorder");
         params.put("userid", UserSession.getInstance(mContext).readPrefs(UserSession.PREFS_USER_ID));
         params.put("name", name);
         params.put("mobileno", mobileNo);
         params.put("address", address);
         params.put("houseno", houseNo);
         params.put("society", socity);
         params.put("landmark", ladmark);
         params.put("zipcode", pincode);
         params.put("city", city);
         params.put("product_data", jsonArray);
         params.put("totalPrice", mycart.gettotalProductPrice());

         mycart.close();

         Log.e("SENDINGDATA",">>>>>"+params);
         httpRequest.getResponse(params, new ServerRespondingListener() {
             @Override
             public void onResponse(String result) {
                 progressDialog.dismiss();
                 Log.e("RESPONSEDATA",">> "+result);

                 try {
                     JSONObject object= new JSONObject(result);
                     if (object.getInt("status")==1){

                         JSONObject responseobj = object.getJSONObject("response");
                       String orderid =  responseobj.getString("order_id");
                         mycart.open();
                         mycart.geleteAllProduct();
                         mycart.close();

                         Intent intent = new Intent(AddressActivity.this, OrderSuccessActivity.class);
                         intent.putExtra("orderid",orderid);
                         startActivity(intent);
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