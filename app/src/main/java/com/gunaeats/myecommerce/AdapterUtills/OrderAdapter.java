 package com.gunaeats.myecommerce.AdapterUtills;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gunaeats.myecommerce.ActivityUtills.ViewOrderDetails;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.model.categorymodel.order.Response;
import com.gunaeats.myecommerce.pojomodel.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


import static com.gunaeats.myecommerce.serverconnection.Constant.thumbnilimage;

public class OrderAdapter  extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    List<Response> orderList;
    Context context;
    int type;

    public OrderAdapter(List<Response> orderList, Context context , int type) {
        this.orderList = orderList;
        this.context = context;
        this.type = type;
        Collections.reverse(this.orderList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.model_my_order,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        if(orderList.get(position).getConfirmStatus()==2){
            holder.jorder_status.setVisibility(View.VISIBLE);
            holder.jorder_status.setText("Completed");
        }else {
            holder.jorder_status.setText("Pending");
        }

        try {
            String imageurl = thumbnilimage+""+ orderList.get(position).getOrderedProducts().get(0).getProducts().get(0).getThumbnailImage();

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.no_image);
            requestOptions.error(R.drawable.no_image);

            Glide.with(context)
                    .setDefaultRequestOptions(requestOptions)
                    .load(imageurl).into(holder.joreder_img);


            holder.jorder_title.setText(""+orderList.get(position).getOrderedProducts().get(0).getProducts().get(0).getProdTitle());
            holder.jorder_id.setText("Order id:"+orderList.get(position).getBookedId());
            holder.jorder_price.setText(context.getResources().getString(R.string.Rs)+" "+orderList.get(position).getTotal());
            holder.jorder_date.setText("Order date: "+orderList.get(position).getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.jrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                   Intent intent = new Intent(context, ViewOrderDetails.class);
                   intent.putExtra("OrderID",orderList.get(position).getBookedId());
                    context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView jorder_title,jorder_id,jorder_price,jorder_date,jorder_status;
        ImageView joreder_img;
        LinearLayout jrl;
        CardView jcard;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            jorder_title=itemView.findViewById(R.id.order_title);
            jorder_id=itemView.findViewById(R.id.order_id);
            jorder_price=itemView.findViewById(R.id.order_price);
            jorder_date=itemView.findViewById(R.id.order_date);
            joreder_img=itemView.findViewById(R.id.p_img);
            jorder_status = itemView.findViewById(R.id.order_status);
            jrl=itemView.findViewById(R.id.rl);
        }
    }
}
