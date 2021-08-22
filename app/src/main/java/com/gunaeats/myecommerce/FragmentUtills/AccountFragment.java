package com.gunaeats.myecommerce.FragmentUtills;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.gunaeats.myecommerce.LoginActivity;
import com.gunaeats.myecommerce.MainActivity;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.UserSession;

import java.net.URLEncoder;

public class AccountFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM = "param";
    private String mParam;
    TextView version,u_nametxt;
    private MainActivity mainActivity;
    ImageView jprofile_pic;

    private LinearLayout llMyProfile;
    private LinearLayout llNotifications;
    private LinearLayout llMyOrders;
    private LinearLayout llManageAddress;
    private LinearLayout llReferAndEarn;
    private LinearLayout llwallet;
    String number;

    public static AccountFragment newInstance(String param) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }

    Button btn_sign_out;
    LinearLayout ac_whatsapp,ac_message;
    TextView mobile_txt,email_txt;
    ImageView msg_id,whatsapp;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        jprofile_pic = v.findViewById(R.id.profile_pic);
        llMyProfile = v.findViewById(R.id.ac_my_profile);
        llMyProfile.setOnClickListener(this);
        ac_whatsapp = v.findViewById(R.id.ac_whatsapp);
        ac_whatsapp.setOnClickListener(this);
        ac_message = v.findViewById(R.id.ac_message);
        ac_message.setOnClickListener(this);
        llNotifications = v.findViewById(R.id.ac_notification);
        llNotifications.setOnClickListener(this);
        llMyOrders = v.findViewById(R.id.ac_my_orders);
        llMyOrders.setOnClickListener(this);
        llManageAddress = v.findViewById(R.id.ac_manage_address);
        llManageAddress.setOnClickListener(this);
        llReferAndEarn = v.findViewById(R.id.ac_refer_and_earn);
        llReferAndEarn.setOnClickListener(this);
        llwallet = v.findViewById(R.id.ac_wallet);
        version = v.findViewById(R.id.version);
        u_nametxt = v.findViewById(R.id.u_nametxt);
        try {
            PackageInfo pInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            String version1 = pInfo.versionName;

            version.setText("V "+version1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        llwallet.setOnClickListener(this);
        btn_sign_out = v.findViewById(R.id.btn_sign_out);


        msg_id = v.findViewById(R.id.msg_id);
      //  msg_id.setTypeface(FontManager.getTypeface(getActivity()));
        whatsapp = v.findViewById(R.id.whatsapp);
       // whatsapp.setTypeface(FontManager.getTypeface(getActivity()));

        btn_sign_out.setOnClickListener(this);
        mobile_txt=v.findViewById(R.id.mobile_txt);

        number = "9406573196";
        //mobile_txt.setText("+91 "+UserSession.getInstance(getActivity()).readPrefs(UserSession.PREFS_USER_MOBILE));
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getActivity().getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }



    private void openWhatsApp() {

        try {

            Uri uri = Uri.parse("smsto:" + "9826356926");
            Intent i = new Intent(Intent.ACTION_SENDTO, uri);
            i.putExtra("sms_body", "hello");
            i.setPackage("com.whatsapp");
            startActivity(i);
        } catch (Throwable e)
        {
            Log.e("error",""+e);
        }
    }
    public void onClickWhat() {
        PackageManager pm=getActivity().getPackageManager();
        try {
            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = "YOUR TEXT HERE";
            PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");
            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(getContext(), "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
        }
    }

    public  void mainsendsmg(){

        PackageManager packageManager = getContext().getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);

        try {
            String url = "https://api.whatsapp.com/send?phone="+ "919589455923" +"&text=" + URLEncoder.encode("");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                getContext().startActivity(i);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void onClickWhatsApp() {

        boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
        try
        {
            if (isWhatsappInstalled) {
                // openWhatsApp();
                PackageManager pm=getActivity().getPackageManager();
                try
                {
                    Uri uri = Uri.parse("content://com.android.contacts/data/" + "8638098453");
                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    String text = "YOUR TEXT HERE";

                    PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    waIntent.setPackage("com.whatsapp");
                    waIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(waIntent, "Share with"));

                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(getActivity(), "WhatsApp not Installed", Toast.LENGTH_SHORT)
                            .show();
                }
            } else {
                Toast.makeText(getActivity(), "WhatsApp not Installed",
                        Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("market://details?id=com.whatsapp");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(goToMarket);

            }
        }catch (Throwable e)
        {
            Log.e("whatsapperror",""+e);
        }

    }


    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        switch (id)
        {
            case R.id.ac_my_profile:
               // startActivity(new Intent(getActivity(), ProfileActivity.class));
                break;
            case R.id.btn_sign_out:
                getActivity().finish();
                UserSession.getInstance(getActivity()).clearPrefs();
                Intent intent =new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;

            case R.id.ac_my_orders:
                //mainActivity.navView.setSelectedItemId(R.id.navigation_orders);
                break;
            case R.id.ac_manage_address:

                break;
            case R.id.ac_refer_and_earn:
            //    startActivity(new Intent(getActivity(), ReferEarn.class));
                break;

            case R.id.ac_wallet:
          //      startActivity(new Intent(getActivity(), OrderSuccessActivity.class));
                break;

            case R.id.ac_message:
                OpenMessage();
                break;

            case R.id.ac_whatsapp:
                CallCustomer(getActivity());
               // mainsendsmg();
                //onClickWhat();
                break;

            case R.id.ac_notification:
        //        startActivity(new Intent(getActivity(), NotificationActivity.class));
                break;
        }
    }


    @SuppressLint("MissingPermission")
    public  void CallCustomer(Context context) {
        try
        {


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
    private void OpenMessage()
    {
        Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "sms:" + getActivity().getResources().getString(R.string.Phonenumber)));
        intent.putExtra( "sms_body", "" );
        startActivity(intent);


    }
}
