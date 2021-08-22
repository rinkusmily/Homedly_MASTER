package com.gunaeats.myecommerce.AdapterUtills;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.pojomodel.DateNodelView;
import com.gunaeats.myecommerce.utils.OnDateSelect;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class DayPurchaseAdapter extends RecyclerView.Adapter<DayPurchaseAdapter.DayPurchaseViewHolder> {

    Context context;
    List<DateNodelView> mDates;
    EditText et_date;
    int lastpostion=-1;
    OnDateSelect onDateSelect;
    boolean isFastTime = true;

    public DayPurchaseAdapter(Context context, List<DateNodelView> mDates, EditText et_date, OnDateSelect onDateSelect) {
        this.context = context;
        this.mDates = mDates;
        this.et_date=et_date;
        this.onDateSelect = onDateSelect;
    }

    @NonNull
    @Override
    public DayPurchaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_retailer_purchase_day,parent,false);
        return new DayPurchaseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final DayPurchaseViewHolder holder, final int position) {
        DateNodelView date1 = mDates.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE", Locale.US);
        String mDay = sdf.format(date1.date);
        sdf = new SimpleDateFormat("d",Locale.US);
        final String mDate = sdf.format(date1.date);

        sdf = new SimpleDateFormat("MMM",Locale.US);
        String mDate1 = sdf.format(date1.date);

        holder.tv_month.setText(mDate1);
        holder.tvDate.setText(mDate);
        holder.tvDay.setText(mDay);

        if(isFastTime){
            mDates.get(0).setSelected(true);
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy",Locale.US);
            String mDate2 = sdf2.format(date1.date);
            et_date.setText(mDate2);
            isFastTime = false;
        }

        if(mDates.get(position).isSelected()){
            holder.lay_update.setBackgroundResource(R.color.purple_500);
            holder.tvDay.setTextColor(context.getResources().getColor(R.color.white));
            holder.tv_month.setTextColor(context.getResources().getColor(R.color.white));
            onDateSelect.onDateSelect(date1.getDate());
        }else {
            holder.lay_update.setBackgroundResource(R.color.white);
            holder.tvDay.setTextColor(context.getResources().getColor(R.color.black));
            holder.tv_month.setTextColor(context.getResources().getColor(R.color.black));
        }

        holder.lay_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DateNodelView date1 = mDates.get(position);

                for(int j=0;j<mDates.size();j++){

                    if(j== position){

                        if(mDates.get(j).isSelected()){
                            mDates.get(j).setSelected(false);
                        }else {
                            mDates.get(j).setSelected(true);
                        }

                    }else {
                        mDates.get(j).setSelected(false);
                    }
                }

                if(position==mDates.get(position).position)
                {

                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy",Locale.US);
                    String mDate = sdf.format(date1.date);
                    et_date.setText(mDate);
                }
                notifyDataSetChanged();
            }
        });
    }

    LinearLayout prev_lay;
    @Override
    public int getItemCount() {
        return mDates.size();
    }

    public class DayPurchaseViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout lay_update,prev_lay;
        TextView tvDate,tv_month;
        TextView tvDay;

        public DayPurchaseViewHolder(View itemView)
        {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tv_month = itemView.findViewById(R.id.tv_month);
            tvDay = itemView.findViewById(R.id.tv_day);
            lay_update = itemView.findViewById(R.id.lay_update);
        }


    }
}
