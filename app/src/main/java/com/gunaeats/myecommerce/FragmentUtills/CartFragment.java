package com.gunaeats.myecommerce.FragmentUtills;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gunaeats.myecommerce.ActivityUtills.AddressActivity;
import com.gunaeats.myecommerce.AdapterUtills.CartItemadapter;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.LocalCartModal;
import com.gunaeats.myecommerce.UAtils.Mycart;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment implements View.OnClickListener{

    static Context mContext;
    CartItemadapter dealadapter;
    RecyclerView recycle_cart;
    ImageView iv_back;
    Button book_service;
   static TextView tvtotalAmount;
   static Mycart mycart;
    View view;
    // Help remove to cart
    // cart order -- total order and 200 side me
    // order summery tersms remove and shedule date time contact detail cheek out
    // name address mobile pincoe landmark
    // my orders -- all aur confirm
    // order details comment

    public CartFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        mContext = getActivity();
        recycle_cart = view.findViewById(R.id.recycle_cart);
        tvtotalAmount = view.findViewById(R.id.total_amount);
        book_service = view.findViewById(R.id.proceed);
        book_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mycart.open();
                if (mycart.countproduct()>0){
                    Intent intent = new Intent(getActivity(), AddressActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(mContext, "Please Add Item From Cart", Toast.LENGTH_SHORT).show();
                }

            }
        });

         mycart = new Mycart(getActivity());
        mycart.open();
        List<LocalCartModal> cartLisst = mycart.getAllProduct();
        tvtotalAmount.setText(getResources().getString(R.string.Rs2100)+" "+mycart.gettotalProductPrice());
        recycle_cart.setHasFixedSize(true);
        recycle_cart.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        dealadapter = new CartItemadapter(getActivity(),cartLisst, 2);

        recycle_cart.setAdapter(dealadapter);



        return view;
    }

    public  static void updateTotal(Context context){
        tvtotalAmount.setText(context.getResources().getString(R.string.Rs2100)+" "+mycart.gettotalProductPrice());
    }

    @Override
    public void onClick(View view) {

    }
}
