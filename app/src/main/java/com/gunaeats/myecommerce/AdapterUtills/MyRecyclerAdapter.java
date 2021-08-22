package com.gunaeats.myecommerce.AdapterUtills;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gunaeats.myecommerce.ActivityUtills.ProductActivityDetail;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.Mycart;
import com.gunaeats.myecommerce.model.categorymodel.products.Productlist;
import com.gunaeats.myecommerce.model.categorymodel.products.Response;
import com.gunaeats.myecommerce.pojomodel.Category;
import com.gunaeats.myecommerce.serverconnection.Constant;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.gunaeats.myecommerce.serverconnection.Constant.IMAGE_URL;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<Response> listItems, filterList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, Productlist listItems)
    {
        this.listItems = listItems.getResponse();
        this.mContext = context;
        this.filterList = new ArrayList<Response>();
        this.filterList.addAll(this.listItems);
    }

    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, null);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tvName.setText(""+filterList.get(i).getProdTitle());
        myViewHolder.mobileno.setText( mContext.getResources().getString(R.string.Rs2100)+" "+filterList.get(i).getProdPrice());

        String strimageurll = filterList.get(i).getBaseUrl()+""+filterList.get(i).getThumbnailImage();
        Log.e("IMAGEURLLL",">>>> "+strimageurll);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.no_image);
        requestOptions.error(R.drawable.no_image);
        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(strimageurll).into(myViewHolder.imgThumb);


        myViewHolder.tvAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mycart mycart = new Mycart(mContext);
                mycart.open();
                if (mycart.checkAvailableProduct(filterList.get(i).getProdId())==1){
                    // TODO: 6/25/2021  update Product
                    mycart.updateQuantity(filterList.get(i).getProdId(),"1");
                    Toast.makeText(mContext, "yes the product is Updated", Toast.LENGTH_SHORT).show();

                }else {
                    // TODO: 6/25/2021  insert Product
                  String  strproductimage = filterList.get(i).getBaseUrl()+""+filterList.get(i).getThumbnailImage();

                    mycart.insertproduct(filterList.get(i).getProdId(),filterList.get(i).getProdTitle(),strproductimage,""+filterList.get(i).getProdPrice(),"1",filterList.get(i).getProdDesc(),filterList.get(i).getProdShortDesc());
                    Toast.makeText(mContext, "yes the product is added", Toast.LENGTH_SHORT).show();
                }

            }
        });


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductActivityDetail.class);
                intent.putExtra("product_id",filterList.get(i).getProdId());
                mContext.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return filterList.size();
    }

    // Do Search...
    public void filter(final String text) {

        // Searching could be complex..so we will dispatch it to a different thread...
        new Thread(new Runnable() {
            @Override
            public void run() {

                // Clear the filter list
                filterList.clear();

                // If there is no search value, then add all original list items to filter list
                if (TextUtils.isEmpty(text)) {

                    filterList.addAll(listItems);

                } else {
                    // Iterate in the original List and add it to filter list...
                    for (Response item : listItems)
                    {
                        if (item.getProdTitle().toLowerCase().contains(text.toLowerCase()))
                       {
                            // Adding Matched items
                          filterList.add(item);
                        }
                    }
                }

                // Set on UI Thread
                ((Activity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Notify the List that the DataSet has changed...
                        notifyDataSetChanged();
                    }
                });

            }
        }).start();

    }

    public static String toTitleCase(String str) {

        if (str == null) {
            return null;
        }

        boolean space = true;
        StringBuilder builder = new StringBuilder(str);
        final int len = builder.length();

        for (int i = 0; i < len; ++i) {
            char c = builder.charAt(i);
            if (space) {
                if (!Character.isWhitespace(c)) {
                    // Convert to title case and switch out of whitespace mode.
                    builder.setCharAt(i, Character.toTitleCase(c));
                    space = false;
                }
            } else if (Character.isWhitespace(c)) {
                space = true;
            } else {
                builder.setCharAt(i, Character.toLowerCase(c));
            }
        }

        return builder.toString();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected TextView tvName,mobileno;
        protected ImageView imgThumb;
        TextView tvAddtoCart;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgThumb = itemView.findViewById(R.id.iv_product_image);
            tvName = itemView.findViewById(R.id.tvName);
            mobileno = itemView.findViewById(R.id.mobileno);
            tvAddtoCart = itemView.findViewById(R.id.id_addtocart);
        }
    }
}
