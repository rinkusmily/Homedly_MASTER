package com.gunaeats.myecommerce.ui.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gunaeats.myecommerce.ActivityUtills.UpdateCartActivity;
import com.gunaeats.myecommerce.AdapterUtills.LaestServiceAdapter;
import com.gunaeats.myecommerce.HomeCatAdapter;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.model.categorymodel.CategoryModel;
import com.gunaeats.myecommerce.pojomodel.Category;
import com.gunaeats.myecommerce.pojomodel.ListItem;
import com.gunaeats.myecommerce.serverconnection.OkHttpRequest;
import com.gunaeats.myecommerce.serverconnection.ServerRespondingListener;
import com.gunaeats.myecommerce.utils.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class HomeFragment extends Fragment {
    private static final String ARG_PARAM = "param";
    private HomeViewModel homeViewModel;
    private RecyclerView jrecycle_category,jrecycle_latest_service;
    HomeCatAdapter catAdapter;
    LaestServiceAdapter laestServiceAdapter;
    ImageView iv_cart;
    ArrayList<ListItem> arrayList = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    SliderLayout sliderLayout;
    LinkedHashMap<String,String> url_maps = new LinkedHashMap<String, String>();

    EditText edtSerchCategory;
    int banner[] ={R.drawable.banner,R.drawable.banner_2};

    public static HomeFragment newInstance(String param) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        sliderLayout = (SliderLayout) root.findViewById(R.id.slider);
        sliderLayout.setDuration(10000l);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        jrecycle_category =root.findViewById(R.id.category_recycle);
        iv_cart =root.findViewById(R.id.iv_cart);

        edtSerchCategory = root.findViewById(R.id.id_search_category);
        edtSerchCategory.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                catAdapter.filter(s.toString());
            }
        });




        jrecycle_latest_service = root.findViewById(R.id.recycle_latest_service);
        jrecycle_latest_service.setHasFixedSize(true);
        jrecycle_latest_service.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        laestServiceAdapter = new LaestServiceAdapter(getContext(), arrayList,1);
        jrecycle_latest_service.setAdapter(laestServiceAdapter);


        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), UpdateCartActivity.class);
                startActivity(intent);

            }
        });
        SetSliderLayout();

        callcategory();

        return root;
    }
    private void SetSliderLayout() {

        for (int name : banner) {

            DefaultSliderView defaultSliderView = new DefaultSliderView(getActivity());
            defaultSliderView.image(name)
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            sliderLayout.addSlider(defaultSliderView);

        }
        sliderLayout.setCurrentPosition(0);
        //sliderLayout.movePrevPosition(false);
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.ZoomOutSlide);

    }

    void callcategory(){

        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        HashMap<String,Object> params = new HashMap<>();
        params.put("action","Category");

        OkHttpRequest httpRequest = new OkHttpRequest(getActivity());
        httpRequest.getResponse(params, new ServerRespondingListener() {
            @Override
            public void onResponse(String result) {
                progressDialog.dismiss();
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                CategoryModel categoryList = gson.fromJson(result,CategoryModel.class);

                if (categoryList.getStatus()==1){
                    // TODO: 6/25/2021  set adaptor
                    jrecycle_category.setLayoutManager(new GridLayoutManager(getContext(),3));
                    jrecycle_category.addItemDecoration(new ItemOffsetDecoration(25));
                    catAdapter = new HomeCatAdapter(categoryList , getContext());
                    jrecycle_category.setAdapter(catAdapter);
                    catAdapter.notifyDataSetChanged();


                }
            }

            @Override
            public void onError(String error) {
                progressDialog.dismiss();
            }
        });
    }


}