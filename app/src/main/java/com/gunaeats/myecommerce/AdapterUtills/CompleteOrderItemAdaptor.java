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
import com.bumptech.glide.request.RequestOptions;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.model.categorymodel.order.Product;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.gunaeats.myecommerce.serverconnection.Constant.thumbnilimage;

public class CompleteOrderItemAdaptor extends RecyclerView.Adapter<CompleteOrderItemAdaptor.MyViewHolder> {
   Context mContext;
    List<Product> productlist;

    public CompleteOrderItemAdaptor(Context mContext, List<Product> productlist) {
        this.mContext = mContext;
        this.productlist = productlist;
    }

    @NonNull
    @NotNull
    @Override
    public CompleteOrderItemAdaptor.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.listlayout_complete_orderitem,viewGroup,false);
        return new CompleteOrderItemAdaptor.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CompleteOrderItemAdaptor.MyViewHolder myViewHolder, int i) {


        try {
            String imageurl = thumbnilimage+""+ productlist.get(i).getThumbnailImage();

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.no_image);
            requestOptions.error(R.drawable.no_image);

            Glide.with(mContext)
                    .setDefaultRequestOptions(requestOptions)
                    .load(imageurl).into(myViewHolder.mImageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        myViewHolder.tvItemName.setText(""+productlist.get(i).getProdTitle());
        myViewHolder.tvitemQuantity.setText(""+productlist.get(i).getNewQuantity());
        myViewHolder.tvitemPrice.setText(""+productlist.get(i).getProdPrice());

    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView tvItemName;
        TextView tvitemPrice;
        TextView tvitemQuantity;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.idmagegproduct);
            tvItemName = itemView.findViewById(R.id.id_name);
            tvitemPrice = itemView.findViewById(R.id.idrate);
            tvitemQuantity = itemView.findViewById(R.id.idquantity);
        }
    }
}
