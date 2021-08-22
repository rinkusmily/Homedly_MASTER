package com.gunaeats.myecommerce.ActivityUtills;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gunaeats.myecommerce.R;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner mSpinner;
    private String[] mQueries = new String[] {"Service 1","Service 2","Service 3","Service 4","Service 5","Service 2","Service 3","Service 4","Service 5","Service 2","Service 3","Service 4","Service 5"};
    EditText et_name,et_number,et_email,et_description,et_pincoden;
    String s_name,s_number,s_email,s_description;
    Button jcalldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Contact Us");
        Initialize();
    }

    ProgressDialog progressDialog;
    public void CallonNumber(View v)
    {
        CallCustomer(ContactUsActivity.this);
    }
    public void Submitdata()
    {
        /**/
    }
    private void Initialize()
    {
        et_name= (EditText) findViewById(R.id.et_name);
        et_number= (EditText) findViewById(R.id.et_number);
        et_email= (EditText) findViewById(R.id.et_email);
        et_description= (EditText) findViewById(R.id.et_description);
        et_pincoden = (EditText) findViewById(R.id.et_pincoden);
        jcalldata = (Button) findViewById(R.id.calldata);
        jcalldata.setOnClickListener(this);
        //
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return super.onSupportNavigateUp();
    }


    private boolean validate(){
        boolean isValid = true;

        String name = et_name.getText().toString();
        String number = et_number.getText().toString();
        String email = et_email.getText().toString();
        String description = et_description.getText().toString();
        String pincode = et_pincoden.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(TextUtils.isEmpty(name)){
            isValid = false;
            Toast.makeText(this, "Enter Your Name", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(number)){
            isValid = false;
            Toast.makeText(this, "Enter Your Number", Toast.LENGTH_SHORT).show();
        }else if(number.length() < 10){
            isValid = false;
            Toast.makeText(this, "Enter Valid Number", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(email)){
            isValid = false;
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }else if(!email.matches(emailPattern)){
            isValid = false;
            Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(pincode)){
            isValid = false;
            Toast.makeText(this, "Enter Valid Pincode", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(description)){
            isValid = false;
            Toast.makeText(this, "Enter Description", Toast.LENGTH_SHORT).show();
        }

        return isValid;
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
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.calldata:

                if(validate()){
                   // sendDetails();
                }
                break;
        }
    }


    @SuppressLint("MissingPermission")
    public static void CallCustomer(Context context) {
        try
        {
            String number=context.getResources().getString(R.string.Phonenumber);

            Log.e("error",""+number);
            String dial = "tel:" + number;

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse(dial));

            ((Activity)context).startActivity(callIntent);
            Log.e("error",""+dial);
        }catch (Throwable e)
        {
            Log.e("error",""+e);
        }
    }
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
