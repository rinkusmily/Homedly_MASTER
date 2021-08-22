package com.gunaeats.myecommerce.FragmentUtills;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gunaeats.myecommerce.AdapterUtills.OrderAdapter;
import com.gunaeats.myecommerce.MainActivity;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.UserSession;
import com.gunaeats.myecommerce.model.categorymodel.order.OrderPojo;
import com.gunaeats.myecommerce.pojomodel.Order;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderAwaitingFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView jrecycle_view;
    LinearLayout jnot_found;
    Button jbook_service;
    ProgressDialog progressDialog;
    View view;
    List<Order> orderList = new ArrayList<>();
    OrderAdapter orderAdapter;
    ProgressBar jprogress;
    private MainActivity mainActivity;

    public OrderAwaitingFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static OrderAwaitingFragment newInstance(String param1, String param2) {
        OrderAwaitingFragment fragment = new OrderAwaitingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        view= inflater.inflate(R.layout.fragment_order_awaiting, container, false);

        init();


        jbook_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.navView.setSelectedItemId(R.id.navigation_home);
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @SuppressLint("WrongConstant")
    private void init(){
        jprogress = (ProgressBar) view.findViewById(R.id.progress);
        jrecycle_view = (RecyclerView) view.findViewById(R.id.recycle_view);
        jrecycle_view.setHasFixedSize(true);
        jrecycle_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL,false));
        jnot_found = (LinearLayout)  view.findViewById(R.id.not_found);
        jbook_service =(Button) view.findViewById(R.id.book_services);

        getHistoryData();
    }


    void getHistoryData(){
        showDialog();
        Map<String,Object> params = new HashMap<>();
        params.put("action","allorderhistory");
        params.put("user_id", UserSession.getInstance(getActivity()).readPrefs(UserSession.PREFS_USER_ID));
        OkHttpRequest httpRequest = new OkHttpRequest(getActivity());
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                closeDialog();
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                OrderPojo myOrder = gson.fromJson(result,OrderPojo.class);

                if (myOrder.getResponse().size()>0){
                    jnot_found.setVisibility(View.GONE);
                    jrecycle_view.setHasFixedSize(true);
                    jrecycle_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
                    orderAdapter = new OrderAdapter(myOrder.getResponse(),getContext(),5);
                    jrecycle_view.setAdapter(orderAdapter);
                    orderAdapter.notifyDataSetChanged();

                }else {
                    jnot_found.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onError(String error) {
                Toast.makeText(getActivity(), "Please Check your Internet Connection!", Toast.LENGTH_SHORT).show();
                closeDialog();
            }
        });

    }


    public void showDialog() {

        progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public void closeDialog() {
        progressDialog.dismiss();
    }
}
