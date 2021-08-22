package com.gunaeats.myecommerce;

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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gunaeats.myecommerce.ActivityUtills.SubCategoryActivity;
import com.gunaeats.myecommerce.model.categorymodel.CategoryModel;
import com.gunaeats.myecommerce.model.categorymodel.Response;
import com.gunaeats.myecommerce.pojomodel.Category;
import com.gunaeats.myecommerce.pojomodel.ListItem;

import java.util.ArrayList;
import java.util.List;

import static com.gunaeats.myecommerce.serverconnection.Constant.IMAGE_URL;

public class HomeCatAdapter extends RecyclerView.Adapter<HomeCatAdapter.MyViewHolder> {

    private List<Response> categories, filterList;
    private Context mContext;
    int count=0;
    public int[] drwable_bg = {R.drawable.chapter_bg_1,R.drawable.chapter_bg_2,R.drawable.chapter_bg_4,R.drawable.chapter_bg_4,R.drawable.chapter_bg_1,R.drawable.chapter_bg_4,R.drawable.chapter_bg_1,R.drawable.chapter_bg_2,R.drawable.chapter_bg_4};
    public HomeCatAdapter(CategoryModel categories, Context mContext) {
        this.categories = categories.getResponse();
        this.mContext = mContext;
        this.filterList = new ArrayList<Response>();
        this.filterList.addAll(this.categories);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {



        View view = LayoutInflater.from(mContext).inflate(R.layout.model_home_cat, null);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {

        holder.jname.setText(filterList.get(i).getCategoryName());

        String strimageurll =IMAGE_URL+filterList.get(i).getImage();
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.no_image);
        requestOptions.error(R.drawable.no_image);
        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(strimageurll).into(holder.jimage);



        for (int c = 1; c < drwable_bg.length; c++) {
            holder.jmanin_ll.setBackgroundResource((drwable_bg[i % 4]));
            if (c == drwable_bg.length)
            {
                c = 1;

            }
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(mContext,ProductListActivity.class);
                Intent intent = new Intent(mContext, SubCategoryActivity.class);
                intent.putExtra("category_id",filterList.get(i).getCategoryId());
                intent.putExtra("category_name",filterList.get(i).getCategoryName());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView jname;
        public ImageView jimage;
        public LinearLayout jmanin_ll;

        public MyViewHolder(View view) {
            super(view);

            jname = view.findViewById(R.id.name);
            jimage = view.findViewById(R.id.image);
            jmanin_ll = view.findViewById(R.id.main_ll);
        }
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

                    filterList.addAll(categories);

                } else {
                    // Iterate in the original List and add it to filter list...
                    for (Response item : categories)
                    {
                        if (item.getCategoryName().toLowerCase().contains(text.toLowerCase()))
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

}
