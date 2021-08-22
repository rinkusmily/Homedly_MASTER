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

import com.gunaeats.myecommerce.ActivityUtills.ProductActivityDetail;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.pojomodel.ListItem;

import java.util.ArrayList;
import java.util.List;

public class LaestServiceAdapter  extends RecyclerView.Adapter<LaestServiceAdapter.MyViewHolder> {

    private List<ListItem> listItems, filterList;
    private Context mContext;
    int type;
    public int[] drwable_bg = {R.drawable.chapter_bg_1,R.drawable.chapter_bg_2,R.drawable.chapter_bg_4,R.drawable.chapter_bg_1,R.drawable.chapter_bg_2,R.drawable.chapter_bg_4,R.drawable.chapter_bg_1,R.drawable.chapter_bg_2,R.drawable.chapter_bg_4};
    public LaestServiceAdapter(Context context, List<ListItem> listItems, int type)
    {
        this.listItems = listItems;
        this.mContext = context;
        this.filterList = new ArrayList<ListItem>();
        this.filterList.addAll(this.listItems);
        this.type = type;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_latest_service, null);
       /* if(type == 1){

        }else {
             view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_home_category_products, null);
        }*/


        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position)
    {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductActivityDetail.class);
                mContext.startActivity(intent);
            }
        });

        for (int c = 1; c < drwable_bg.length; c++) {

            holder.jmain_ll.setBackgroundResource((drwable_bg[position % 4]));


            if (c == drwable_bg.length)
            {
                c = 1;
                //int color = drw[c];
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
                    for (ListItem item : listItems)
                    {
                        if (item.getTitle().toLowerCase().contains(text.toLowerCase()) ||
                                item.getDescription().toLowerCase().contains(text.toLowerCase()))
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



