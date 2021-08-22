package com.gunaeats.myecommerce.AdapterUtills;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.pojomodel.CartModel;
import com.gunaeats.myecommerce.utils.QuantityListner;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    List<CartModel> cartModels;
    Context context;
    int quantity = 1,price;
    QuantityListner listner;


    public CartAdapter(List<CartModel> cartModels, Context context , QuantityListner listner) {
        this.cartModels = cartModels;
        this.context = context;
        this.listner=listner;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_cart2,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {

        try {



            Glide.with(context).load(R.drawable.soap).into(holder.jpro_img);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView jcat_name, jservice_name, jvarient, jprice, jquantity;
        public ImageView jplus, jminus, jcross,jpro_img;

        public MyViewHolder(View view) {
            super(view);
            //jcat_name = view.findViewById(R.id.cat_name);
            // jservice_name = view.findViewById(R.id.service_name);
            //  jvarient = view.findViewById(R.id.sub_cat_name);
            jservice_name = view.findViewById(R.id.service_name);
            jprice = view.findViewById(R.id.price);
            jquantity = view.findViewById(R.id.quantity);
            jplus = view.findViewById(R.id.plus);
            jminus = view.findViewById(R.id.minus);
            jcross = view.findViewById(R.id.delete);
            jpro_img = view.findViewById(R.id.pro_img);
        }



    }

    public  String isNullReturnBlank (String value) {
        if(value != null){
            return value;
        }else {
            return "";
        }
    }
}
