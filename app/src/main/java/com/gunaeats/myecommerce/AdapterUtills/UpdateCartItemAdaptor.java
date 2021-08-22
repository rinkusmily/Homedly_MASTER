package com.gunaeats.myecommerce.AdapterUtills;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.LocalCartModal;
import com.gunaeats.myecommerce.UAtils.Mycart;

import java.util.List;

import static com.gunaeats.myecommerce.ActivityUtills.UpdateCartActivity.updateTotal;


public class UpdateCartItemAdaptor extends RecyclerView.Adapter<UpdateCartItemAdaptor.MyViewHolder> {

    private Context mContext;
    int count=0;
    int type;
    List<LocalCartModal> cartList;
    Mycart mycart;
    public UpdateCartItemAdaptor( Context mContext, List<LocalCartModal> cartList, int type) {
        this.cartList = cartList;
        this.mContext = mContext;
        this.type = type;
        mycart = new Mycart(mContext);
    }

    @Override
    public UpdateCartItemAdaptor.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item_cart, null);
        UpdateCartItemAdaptor.MyViewHolder viewHolder = new UpdateCartItemAdaptor.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpdateCartItemAdaptor.MyViewHolder holder, final int i) {

        holder.tvproductName.setText(cartList.get(i).getName());
        holder.quantity.setText(cartList.get(i).getQuantity());
        holder.tvProductprice.setText(mContext.getResources().getString(R.string.Rs2100)+" "+cartList.get(i).getPrice());

        double itemPrice = Double.parseDouble(cartList.get(i).getPrice())* Integer.parseInt(cartList.get(i).getQuantity());
        holder.tvitemPrice.setText(mContext.getResources().getString(R.string.Rs2100)+" "+itemPrice);


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.no_image);
        requestOptions.error(R.drawable.no_image);
        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(cartList.get(i).getImage()).into(holder.cartImage);



        holder.ic_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number =  holder.quantity.getText().toString();
                int val = Integer.parseInt(number);
                if (val>1){
                    val = val - 1;
                    holder.quantity.setText(""+val);
                    mycart.open();
                    mycart.updateQuantity(cartList.get(i).getId(),""+val);
                    mycart.close();
                    double itemPrice = Double.parseDouble(cartList.get(i).getPrice())* val;
                    holder.tvitemPrice.setText(mContext.getResources().getString(R.string.Rs2100)+" "+itemPrice);
                    updateTotal(mContext);
                }
            }
        });
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number =  holder.quantity.getText().toString();
                int val = Integer.parseInt(number);
                val = val +1;
                Log.d("TAG", "onClick: "+val);
                holder.quantity.setText(""+val);
                mycart.open();
                mycart.updateQuantity(cartList.get(i).getId(),""+val);
                mycart.close();
                double itemPrice = Double.parseDouble(cartList.get(i).getPrice())* val;
                holder.tvitemPrice.setText(mContext.getResources().getString(R.string.Rs2100)+" "+itemPrice);
                updateTotal(mContext);
            }
        });

        holder.deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteAlert(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView quantity;
        public ImageView plus,ic_minus;
        public LinearLayout jmanin_ll,llbg;
        ImageView cartImage;
        ImageView deleteImage;
        TextView tvProductprice;
        TextView tvitemPrice;
        TextView tvproductName;


        public MyViewHolder(View view) {
            super(view);

            plus = view.findViewById(R.id.plus);
            ic_minus = view.findViewById(R.id.minus);
            quantity = view.findViewById(R.id.quantity);
            cartImage = view.findViewById(R.id.sitem);
            tvProductprice = view.findViewById(R.id.price);
            tvitemPrice = view.findViewById(R.id.pro_img);
            deleteImage = view.findViewById(R.id.delete);
            tvproductName = view.findViewById(R.id.service_name);

        }
    }


    void deleteAlert(int position){

        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                mContext);

// Setting Dialog Title
        alertDialog2.setTitle("Confirm Delete...");

// Setting Dialog Message
        alertDialog2.setMessage("Are you sure you want delete this "+ cartList.get(position).getName());

// Setting Icon to Dialog
        // alertDialog2.setIcon(R.drawable.delete);

// Setting Positive "Yes" Btn
        alertDialog2.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        mycart.open();
                        mycart.deleteproduct(cartList.get(position).getId());
                        mycart.close();
                        cartList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, cartList.size());
                        updateTotal(mContext);
                    }
                });
        alertDialog2.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog

                        dialog.cancel();
                    }
                });

// Showing Alert Dialog
        alertDialog2.show();
    }
}
