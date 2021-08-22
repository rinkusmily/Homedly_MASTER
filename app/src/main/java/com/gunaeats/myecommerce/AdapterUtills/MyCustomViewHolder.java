package com.gunaeats.myecommerce.AdapterUtills;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyCustomViewHolder extends RecyclerView.ViewHolder {

    protected ImageView imageView;
    protected TextView tvName, tvPlace,mobileno;
    protected ImageView imgThumb;
    LinearLayout clicklay;
    public MyCustomViewHolder(View view)
    {
        super(view);
    }

}
