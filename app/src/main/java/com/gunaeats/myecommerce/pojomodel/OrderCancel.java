package com.gunaeats.myecommerce.pojomodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderCancel implements Serializable
{

    @SerializedName("orderid")
    @Expose
    private String orderid;
    @SerializedName("mydate")
    @Expose
    private String mydate;
    @SerializedName("cancelbycustomer")
    @Expose
    private String cancelbycustomer;
    @SerializedName("cancelbypartner")
    @Expose
    private String cancelbypartner;
    @SerializedName("cancelreason")
    @Expose
    private String cancelreason;
    @SerializedName("remark")
    @Expose
    private String remark;
    private final static long serialVersionUID = -2112460915718202050L;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getMydate() {
        return mydate;
    }

    public void setMydate(String mydate) {
        this.mydate = mydate;
    }

    public String getCancelbycustomer() {
        return cancelbycustomer;
    }

    public void setCancelbycustomer(String cancelbycustomer) {
        this.cancelbycustomer = cancelbycustomer;
    }

    public String getCancelbypartner() {
        return cancelbypartner;
    }

    public void setCancelbypartner(String cancelbypartner) {
        this.cancelbypartner = cancelbypartner;
    }

    public String getCancelreason() {
        return cancelreason;
    }

    public void setCancelreason(String cancelreason) {
        this.cancelreason = cancelreason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

