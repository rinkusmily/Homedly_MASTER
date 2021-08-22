package com.gunaeats.myecommerce.AdapterUtills;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gunaeats.myecommerce.ActivityUtills.ProductListActivity;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.model.categorymodel.subcategory.Response;
import com.gunaeats.myecommerce.model.categorymodel.subcategory.Subcategorylist;
import com.gunaeats.myecommerce.pojomodel.ListItem;

import java.util.ArrayList;
import java.util.List;

import static com.gunaeats.myecommerce.serverconnection.Constant.IMAGE_URL;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder> {

    private List<Response> listItems, filterList;
    private Context mContext;
    int type;
    public int[] drwable_bg = {R.drawable.chapter_bg_1,R.drawable.chapter_bg_2,R.drawable.chapter_bg_4,R.drawable.chapter_bg_1,R.drawable.chapter_bg_2,R.drawable.chapter_bg_4,R.drawable.chapter_bg_1,R.drawable.chapter_bg_2,R.drawable.chapter_bg_4};
    public SubCategoryAdapter(Context context, Subcategorylist listItems, int type)
    {
        this.listItems = listItems.getResponse();
        this.mContext = context;
        this.filterList = new ArrayList<Response>();
        this.filterList.addAll(this.listItems);
        this.type = type;
    }

    @Override
    public SubCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_latest_service, null);
       /* if(type == 1){

        }else {
             view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_home_category_products, null);
        }*/


        SubCategoryAdapter.MyViewHolder viewHolder = new SubCategoryAdapter.MyViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(SubCategoryAdapter.MyViewHolder holder, final int position)
    {

        holder.jname.setText(filterList.get(position).getSubCategoryName());

        String strimageurll =IMAGE_URL+filterList.get(position).getSubcateImage();
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.no_image);
        requestOptions.error(R.drawable.no_image);
        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(strimageurll).into(holder.jimg);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductListActivity.class);
                intent.putExtra("category_id",filterList.get(position).getCategoryId());
                intent.putExtra("subcategory_id",filterList.get(position).getSubCategoryId());
                intent.putExtra("subcategory_name",filterList.get(position).getSubCategoryName());
                mContext.startActivity(intent);

            }
        });

        for (int c = 1; c < drwable_bg.length; c++) {

            holder.jmain_ll.setBackgroundResource((drwable_bg[position % 4]));
            if (c == drwable_bg.length)
            {
                c = 1;
            }
        }

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
                        if (item.getSubCategoryName().toLowerCase().contains(text.toLowerCase()))
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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView jname;
        public ImageView jimg;
        public LinearLayout jmain_ll;

        public MyViewHolder(View view) {
            super(view);
            jname = view.findViewById(R.id.name);
            jimg = view.findViewById(R.id.image);
            jmain_ll = view.findViewById(R.id.main_ll);
        }
    }

}



