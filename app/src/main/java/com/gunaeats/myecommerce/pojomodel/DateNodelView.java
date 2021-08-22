package com.gunaeats.myecommerce.pojomodel;

import java.util.Date;

public class DateNodelView {
    public Date date;
    public int position;
    boolean isSelected;

    public DateNodelView(int pos,Date date) {
        this.date=date;
        this.position=pos;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}


