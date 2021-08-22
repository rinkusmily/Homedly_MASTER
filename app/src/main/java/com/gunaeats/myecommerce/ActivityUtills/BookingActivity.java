package com.gunaeats.myecommerce.ActivityUtills;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gunaeats.myecommerce.AdapterUtills.BookTimeAdapter;
import com.gunaeats.myecommerce.AdapterUtills.DayPurchaseAdapter;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.pojomodel.AddressModel;
import com.gunaeats.myecommerce.pojomodel.BookTimeModel;
import com.gunaeats.myecommerce.pojomodel.DateNodelView;
import com.gunaeats.myecommerce.utils.OnDateSelect;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class BookingActivity extends AppCompatActivity implements OnDateSelect{

    String tcd_id,come_from,json,cat_id;
    ProgressDialog progressDialog;
    EditText et_date, et_time;
    EditText et_remark;
    //        public string PrdId { get; set; }
    //        public string quanitity { get; set; }
    //        public string price { get; set; }
    //        public string totalprice { get; set; }
    //        public string discount { get; set; }
    //        public string priceafterdiscount { get; set; }

    String randomMobile;
    RecyclerView date_rec, time_rec;
    RecyclerView time_rec_after, time_rec_even;
    ArrayList<BookTimeModel> booktime = new ArrayList<>();
    AddressModel addressModel;
    String serverdate;
    RelativeLayout jmainLayout;
    ProgressBar jprogress;
    OnDateSelect onDateSelect;

    private String getRandom() {
        int n = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            n = ThreadLocalRandom.current().nextInt(100000, 999999);
        }
        String Comman = getResources().getString(R.string.app_name);
        Comman = Comman.substring(0, 4);
        return Comman + "-" + n;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        getSupportActionBar().setTitle("Schedule an appointment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        jmainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        jprogress  = (ProgressBar) findViewById(R.id.progress);

        onDateSelect = (OnDateSelect)this;
        et_date = findViewById(R.id.et_date);
        getDateTime();

        tcd_id = getIntent().getStringExtra("tcd_id");
        cat_id = getIntent().getStringExtra("cat_id");
        come_from = getIntent().getStringExtra("come_from");
        addressModel = (AddressModel) getIntent().getSerializableExtra("addressModel");


        randomMobile = getRandom();
        et_remark = findViewById(R.id.remark);

        et_time = findViewById(R.id.et_time);
        Button btn_check_out = (Button) findViewById(R.id.btn_check_out);


        btn_check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isValidate()){

                        startActivity(new Intent(BookingActivity.this,OrderSummary.class)
                                .putExtra("tcd_id",""+"tcd_id")
                                .putExtra("cat_id",""+"cat_id")
                                .putExtra("addressmodel","addressModel")
                                .putExtra("schdule_date",""+et_date.getText().toString())
                                .putExtra("schedule_time",""+et_time.getText().toString())
                                .putExtra("remark",et_remark.getText().toString()));

                }
            }
        });
    }

    private boolean isValidate(){
        boolean valid = true;

        String date = et_date.getText().toString();
        String time = et_time.getText().toString();
        String remark = et_remark.getText().toString();

        if(TextUtils.isEmpty(date)){
            valid = false;
            Toast.makeText(this, "Please choose date", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(time)){
            valid = false;
            Toast.makeText(this, "Please Choose time", Toast.LENGTH_SHORT).show();
        }/*else if(TextUtils.isEmpty(remark)){
            valid = false;
            Toast.makeText(this, "Please Enter Remark", Toast.LENGTH_SHORT).show();
        }*/

        return valid;
    }

    private void SetTimeRec() {
        booktime.clear();
        time_rec = (RecyclerView) findViewById(R.id.time_rec);
        time_rec.setHasFixedSize(true);
        time_rec.setLayoutManager(new GridLayoutManager(this, 2));
        booktime.add(new BookTimeModel("title", "Morning", ""));
        booktime.add(new BookTimeModel("title", "", ""));/*
        booktime.add(new BookTimeModel("time","07:00 AM-08:00 AM","07:00"));
        booktime.add(new BookTimeModel("time","08:00 AM-09:00 AM","08:00"));
        booktime.add(new BookTimeModel("time","09:00 AM-10:00 AM","09:00"));*/
        booktime.add(new BookTimeModel("time", "09:00 AM-12:00 PM", "09:00 AM-12:00 PM"));
        //  booktime.add(new BookTimeModel("time","11:00 AM-12:00 PM","11:00"));
        booktime.add(new BookTimeModel("blank", "", ""));
        booktime.add(new BookTimeModel("title", "Afternoon", ""));
        booktime.add(new BookTimeModel("title", "", ""));
        booktime.add(new BookTimeModel("time", "12:00 PM-03:00 PM", "12:00 PM-03:00 PM"));
       /* booktime.add(new BookTimeModel("time","01:00 PM-02:00 PM","01:00"));
        booktime.add(new BookTimeModel("time","02:00 PM-03:00 PM","02:00"));
       */
        booktime.add(new BookTimeModel("time", "03:00 PM-06:00 PM", "03:00 PM-06:00 PM"));
       // booktime.add(new BookTimeModel("time", "04:00 PM-06:00 PM", "04:00 PM-06:00 PM"));
      //  booktime.add(new BookTimeModel("blank", "", ""));
        booktime.add(new BookTimeModel("title", "Evening", ""));
        booktime.add(new BookTimeModel("title", "", ""));
        // booktime.add(new BookTimeModel("time","05:00 PM-06:00 PM","05:00"));
        booktime.add(new BookTimeModel("time", "06:00 PM-08:00 PM", "06:00 PM-08:00 PM"));
        // booktime.add(new BookTimeModel("time","07:00 PM-08:00 PM","07:00"));

        BookTimeAdapter bookTimeAdapter = new BookTimeAdapter(getApplicationContext(), booktime, et_time);
        time_rec.setAdapter(bookTimeAdapter);


    }

    private void SetTimeRec2() {
        booktime.clear();
        time_rec = (RecyclerView) findViewById(R.id.time_rec);
        time_rec.setHasFixedSize(true);
        time_rec.setLayoutManager(new GridLayoutManager(this, 2));

        booktime.add(new BookTimeModel("title", "Afternoon", ""));
        booktime.add(new BookTimeModel("title", "", ""));
        booktime.add(new BookTimeModel("time", "12:00 PM-03:00 PM", "12:00 PM-03:00 PM"));
       /* booktime.add(new BookTimeModel("time","01:00 PM-02:00 PM","01:00"));
        booktime.add(new BookTimeModel("time","02:00 PM-03:00 PM","02:00"));
       */
        booktime.add(new BookTimeModel("time", "03:00 PM-06:00 PM", "03:00 PM-06:00 PM"));
        // booktime.add(new BookTimeModel("time", "04:00 PM-06:00 PM", "04:00 PM-06:00 PM"));
        //  booktime.add(new BookTimeModel("blank", "", ""));
        booktime.add(new BookTimeModel("title", "Evening", ""));
        booktime.add(new BookTimeModel("title", "", ""));
        // booktime.add(new BookTimeModel("time","05:00 PM-06:00 PM","05:00"));
        booktime.add(new BookTimeModel("time", "06:00 PM-08:00 PM", "06:00 PM-08:00 PM"));
        // booktime.add(new BookTimeModel("time","07:00 PM-08:00 PM","07:00"));

        BookTimeAdapter bookTimeAdapter = new BookTimeAdapter(getApplicationContext(), booktime, et_time);
        time_rec.setAdapter(bookTimeAdapter);
    }

    private void SetTimeRec3() {
        booktime.clear();
        time_rec = (RecyclerView) findViewById(R.id.time_rec);
        time_rec.setHasFixedSize(true);
        time_rec.setLayoutManager(new GridLayoutManager(this, 2));

        booktime.add(new BookTimeModel("title", "Afternoon", ""));
        booktime.add(new BookTimeModel("title", "", ""));

        booktime.add(new BookTimeModel("time", "03:00 PM-06:00 PM", "03:00 PM-06:00 PM"));
        // booktime.add(new BookTimeModel("time", "04:00 PM-06:00 PM", "04:00 PM-06:00 PM"));
        booktime.add(new BookTimeModel("blank", "", ""));
        booktime.add(new BookTimeModel("title", "Evening", ""));
        booktime.add(new BookTimeModel("title", "", ""));
        // booktime.add(new BookTimeModel("time","05:00 PM-06:00 PM","05:00"));
        booktime.add(new BookTimeModel("time", "06:00 PM-08:00 PM", "06:00 PM-08:00 PM"));
        // booktime.add(new BookTimeModel("time","07:00 PM-08:00 PM","07:00"));

        BookTimeAdapter bookTimeAdapter = new BookTimeAdapter(getApplicationContext(), booktime, et_time);
        time_rec.setAdapter(bookTimeAdapter);
    }

    private void SetTimeRec4() {
        booktime.clear();
        time_rec = (RecyclerView) findViewById(R.id.time_rec);
        time_rec.setHasFixedSize(true);
        time_rec.setLayoutManager(new GridLayoutManager(this, 2));
        booktime.add(new BookTimeModel("title", "Evening", ""));
        booktime.add(new BookTimeModel("title", "", ""));
        // booktime.add(new BookTimeModel("time","05:00 PM-06:00 PM","05:00"));
        booktime.add(new BookTimeModel("time", "06:00 PM-08:00 PM", "06:00 PM-08:00 PM"));
        // booktime.add(new BookTimeModel("time","07:00 PM-08:00 PM","07:00"));

        BookTimeAdapter bookTimeAdapter = new BookTimeAdapter(getApplicationContext(), booktime, et_time);
        time_rec.setAdapter(bookTimeAdapter);
    }

    private void SetDateView() {
        serverdate ="Thu Feb 11 05:05:20 GMT+05:30 2021";
        date_rec = (RecyclerView) findViewById(R.id.date_rec);
        date_rec.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(BookingActivity.this, LinearLayoutManager.HORIZONTAL, false);
        date_rec.setLayoutManager(horizontalLayoutManagaer);
        date_rec.setAdapter(new DayPurchaseAdapter(getApplicationContext(), getDates(), et_date,onDateSelect));
        jprogress.setVisibility(View.GONE);
        jmainLayout.setVisibility(View.VISIBLE);
        SetTimeRec();
       // compareTime();
    }

    private void compareTime(){

        try {

            int currentHour = 0;
                SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy kk:mm:ss");
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
                DateFormat outputformat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
                Date date23 = null;
                String output = null;
                    //Converting the input String to Date
                    date23= df.parse(serverdate);
                    //Changing the format of date and storing it in String
                    output = outputformat.format(date23);
                    String h = output.substring(11,13);
                    currentHour = Integer.parseInt(h);
                    //Displaying the date
                    System.out.println(output);
            if(currentHour < 9) {
                SetTimeRec();
            }else if(currentHour == 9 || currentHour == 10 || currentHour == 11){
                SetTimeRec2();
            }else if(currentHour == 12 || currentHour == 13 || currentHour == 14){
                SetTimeRec3();
            }else if(currentHour == 15 || currentHour == 16 || currentHour == 17) {
                SetTimeRec4();
            }else if(currentHour >= 18){
                //SetDateView2();
            }
            else {
                //SetDateView2();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<DateNodelView> getDates() {
        ArrayList<DateNodelView> mDates = new ArrayList<>();

        //old code
        /*Calendar mCalendar = Calendar.getInstance();
        Date date = new Date(new Date().getTime() + 28800000);*/


        /*new code by anmol*/

        int currentHour = 0;

        try {

            SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy kk:mm:ss");
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
            DateFormat outputformat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            Date date23 = null;
            String output = null;
            try{
                //Converting the input String to Date
                serverdate = "3/10/2021 4:09:00 PM +05:30";
                date23= df.parse(serverdate);
                //Changing the format of date and storing it in String
               output = outputformat.format(date23);
                String h = output.substring(11,13);
                currentHour = Integer.parseInt(h);
                //Displaying the date
                System.out.println(output);
            }catch(ParseException pe){
                pe.printStackTrace();
            }

            if(currentHour >= 18){

                Date date=null;

                try {

                    SimpleDateFormat formatter2 = new SimpleDateFormat("M/d/yyyy hh:mm:ss aa");
                    String dateInString = "7-Jun-2013";

                    Date date1 = formatter2.parse(serverdate);
                  //  getting current date from server plus one day to date eg.(current-date 19 our-date 20)
                    date = new Date(date1.getTime() + (1000 * 60 * 60 * 24));
                    System.out.println("-date------------"+date);

                } catch (ParseException e) {
                    e.printStackTrace();
                }


                for (int i = 0; i < 20; i++) {

                    mDates.add(new DateNodelView(i, new Date(date.getTime() + (i * 24 * 60 * 60 * 1000))));
                }

            }else {

                Date date=null;

                try {

                    SimpleDateFormat formatter2 = new SimpleDateFormat("M/d/yyyy hh:mm:ss aa");
                    String dateInString = "7-Jun-2013";

                    Date date1 = formatter2.parse(serverdate);
                    //getting current date from server plus one day to date eg.(current-date 19 our-date 20)
                    //date = new Date(date1.getTime() + (1000 * 60 * 60 * 24));
                    date = new Date(date1.getTime());
                    System.out.println("-date------------"+date);

                } catch (ParseException e) {
                    e.printStackTrace();
                }


                for (int i = 0; i < 20; i++) {

                    mDates.add(new DateNodelView(i, new Date(date.getTime() + (i * 24 * 60 * 60 * 1000))));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return mDates;
    }

    private void insertOrder(){
        startActivity(new Intent(BookingActivity.this,OrderSuccessActivity.class));
        finish();}

    public void showDialog() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public void closeDialog() {
        progressDialog.dismiss();
    }

    public String isNullReturnBlank (String value) {
        if(value != null || value.isEmpty()){
            return value;
        }else {
            return "";
        }
    }

    private void getDateTime(){

        SetDateView();
        jprogress.setVisibility(View.GONE);

    }

    @Override
    public void onDateSelect(Date date) {
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy hh:mm:ss aa");
            Date date1 = formatter.parse(serverdate);
            if(date1.equals(date)){
                compareTime();
            }else {
                SetTimeRec();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private int getTime(String time){
        int hour = 0;
       // final String time = "23:15";
        Log.e("getTime",""+time);

        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
            final Date dateObj = sdf.parse(time);
            System.out.println(dateObj);
            System.out.println(new SimpleDateFormat("K:mm").format(dateObj));
            hour = Integer.parseInt(new SimpleDateFormat("K:mm").format(dateObj));
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return hour;
    }
}
