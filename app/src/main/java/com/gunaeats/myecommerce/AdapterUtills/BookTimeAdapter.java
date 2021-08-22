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
import com.gunaeats.myecommerce.pojomodel.BookTimeModel;

import java.util.ArrayList;

public class BookTimeAdapter extends RecyclerView.Adapter<BookTimeAdapter.ViewHolderTime> {

    Context context;
    ArrayList<BookTimeModel> booktime;
    EditText et_time;

    public BookTimeAdapter(Context context, ArrayList<BookTimeModel> booktime, EditText et_time)
    {
        this.context=context;
        this.booktime=booktime;
        this.et_time=et_time;
    }
    @NonNull
    @Override
    public ViewHolderTime onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.booking_time_core,viewGroup,false);
        return new ViewHolderTime(v);
    }

    LinearLayout prev_lay;
    TextView prev_txt;
    @Override
    public void onBindViewHolder(@NonNull final ViewHolderTime viewHolderTime, int i) {
        final BookTimeModel bookTimeModel=booktime.get(i);

        if(bookTimeModel.type.equals("title"))
        {
            viewHolderTime.txt_title.setVisibility(View.VISIBLE);
            viewHolderTime.txt_title.setText(bookTimeModel.value);
        }else if(bookTimeModel.type.equals("time"))
        {
            viewHolderTime.lay_time.setVisibility(View.VISIBLE);
            viewHolderTime.time.setText(bookTimeModel.value);
        }


        viewHolderTime.time.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                try
                {
                    prev_txt.setTextColor(context.getResources().getColor(R.color.black));
                    prev_lay.setBackground(context.getResources().getDrawable(R.drawable.border_radiousred));
                }catch ( Throwable e)
                {

                }
                viewHolderTime.lay_time.setBackground(context.getResources().getDrawable(R.drawable.border_radiousred_dark));
                viewHolderTime.time.setTextColor(context.getResources().getColor(R.color.white));
                prev_lay=viewHolderTime.lay_time;
                prev_txt=viewHolderTime.time;
                et_time.setText(bookTimeModel.key_value);

            }
        });
    }

    @Override
    public int getItemCount() {
        return booktime.size();
    }

    public class ViewHolderTime extends RecyclerView.ViewHolder {
        public LinearLayout lay_title,lay_time;
        public TextView txt_title,time;
        public ViewHolderTime(View v) {
            super(v);
            lay_time=(LinearLayout)v.findViewById(R.id.lay_time);
            time=(TextView) v.findViewById(R.id.time);
            txt_title=(TextView) v.findViewById(R.id.txt_title);
        }
    }
}
