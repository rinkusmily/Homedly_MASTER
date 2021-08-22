package com.gunaeats.myecommerce.FragmentUtills;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.gunaeats.myecommerce.ActivityUtills.ContactUsActivity;
import com.gunaeats.myecommerce.ActivityUtills.DynamicWebActivity;
import com.gunaeats.myecommerce.R;


public class HelpFragment extends Fragment implements View.OnClickListener{

    private TextView tvHelpContactUs;
    private TextView tvHelpFaqAndTerms;
    private TextView tvHelpPrivacyPolicy;
    private TextView tvHelpAboutUs;
    private TextView help_discliamer;
    private TextView help_cancellation;
    private TextView help_return_refund;
    private TextView help_faq,help_complain;
    View view;
    private static final String ARG_PARAM = "param";

    public HelpFragment() {
        // Required empty public constructor
    }

    public static HelpFragment newInstance(String param) {
        HelpFragment fragment = new HelpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_order_details, container, false);
        tvHelpContactUs = (TextView) view.findViewById(R.id.help_contact_us);
        tvHelpContactUs.setOnClickListener(this);
        help_return_refund = (TextView) view.findViewById(R.id.help_return_refund);
        help_return_refund.setOnClickListener(this);
        help_cancellation = (TextView) view.findViewById(R.id.help_cancellation);
        help_cancellation.setOnClickListener(this);
        tvHelpFaqAndTerms = (TextView) view.findViewById(R.id.help_faq_and_terms);
        help_discliamer = (TextView) view.findViewById(R.id.help_discliamer);
        tvHelpFaqAndTerms.setOnClickListener(this);
        help_discliamer.setOnClickListener(this);
        tvHelpPrivacyPolicy = (TextView) view.findViewById(R.id.help_privacy_policy);
        tvHelpPrivacyPolicy.setOnClickListener(this);
        tvHelpAboutUs = (TextView) view.findViewById(R.id.help_about_us);
        tvHelpAboutUs.setOnClickListener(this);
        help_faq = (TextView) view.findViewById(R.id.help_faq);
        help_faq.setOnClickListener(this);
        help_complain = (TextView) view.findViewById(R.id.help_complain);
        help_complain.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent(getContext(), DynamicWebActivity.class);
        switch (id) {
            case R.id.help_contact_us:
                startActivity(new Intent(getContext(), ContactUsActivity.class));
                break;
            case R.id.help_faq_and_terms:
                /*intent.putExtra("title","FAQ & Terms");
                GlobalList.SavePreferences(getApplicationContext(),"help_cooman_url",SOAPConst.Method.TERMS_AND_CONDITIONS);
                startActivity(intent);*/
              //  startActivity(new Intent(getContext(), OrderSummary.class));
                intent.putExtra("title","TermsCondition");
                intent.putExtra("url","Other_Terms_And_Condition");
                startActivity(intent);
                break;
            case R.id.help_privacy_policy:
                /*intent.putExtra("title","Privacy Policy");
                GlobalList.SavePreferences(getApplicationContext(),"help_cooman_url",SOAPConst.Method.PRIVACY_POLICY);

                startActivity(intent);*/
                //startActivity(new Intent(getContext(), MedicineActivity.class));
                intent.putExtra("title","Privacy Policy");
                intent.putExtra("url","Other_Privacy_Policy");
                startActivity(intent);
                break;
            case R.id.help_about_us:
             /*   GlobalList.SavePreferences(getApplicationContext(),"help_cooman_url", SOAPConst.Method.ABOUT_US);
                intent.putExtra("title","About Us");
                startActivity(intent);*/
               // startActivity(new Intent(getContext(), LaundryServiceActivity.class));
                intent.putExtra("title","About Us");
                intent.putExtra("url","Other_About_us_App");
                startActivity(intent);
                break;

            case R.id.help_discliamer:
               // GlobalList.SavePreferences(getContext(),"help_cooman_url","Disclaimer");
                intent.putExtra("title","Disclaimer");
                intent.putExtra("url","Other_Disclaimer");
                startActivity(intent);
                break;

            case R.id.help_cancellation:
              //  GlobalList.SavePreferences(getContext(),"help_cooman_url","Cancellation");
                intent.putExtra("title","Cancellation");
                intent.putExtra("url","Other_Cancellation");
                startActivity(intent);
                break;

            case R.id.help_return_refund:
             //   GlobalList.SavePreferences(getContext(),"help_cooman_url","Return_And_Refund");
                intent.putExtra("title","Return And Refund");
                intent.putExtra("url","Other_ReturnAndRefund");
                startActivity(intent);
                break;

            case R.id.help_complain:
               // startActivity(new Intent(getContext(), ComplainActivity.class));
                break;

            case R.id.help_faq:
                //   GlobalList.SavePreferences(getContext(),"help_cooman_url","Return_And_Refund");
                intent.putExtra("title","FAQ");
                intent.putExtra("url","Other_FAQ");
                startActivity(intent);
                break;
        }
    }
}
