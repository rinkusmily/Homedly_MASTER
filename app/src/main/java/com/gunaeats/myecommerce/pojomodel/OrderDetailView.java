package com.gunaeats.myecommerce.pojomodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderDetailView implements Serializable {

    @SerializedName("productname")
    @Expose
    private String productname;
    @SerializedName("prdcode")
    @Expose
    private String prdcode;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("quanitity")
    @Expose
    private Integer quanitity;
    @SerializedName("totalprice")
    @Expose
    private Integer totalprice;
    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("discountedprice")
    @Expose
    private Integer discountedprice;
    @SerializedName("smallurl")
    @Expose
    private String smallurl;

    public String getProductvariant() {
        return productvariant;
    }
    public void setProductvariant(String productvariant) {
        this.productvariant = productvariant;
    }

    @SerializedName("productvariant")
    @Expose
    private String productvariant;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @SerializedName("remark")
    @Expose
    private String remark;
    private final static long serialVersionUID = 5779052344324060317L;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPrdcode() {
        return prdcode;
    }

    public void setPrdcode(String prdcode) {
        this.prdcode = prdcode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(Integer quanitity) {
        this.quanitity = quanitity;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getDiscountedprice() {
        return discountedprice;
    }

    public void setDiscountedprice(Integer discountedprice) {
        this.discountedprice = discountedprice;
    }

    public String getSmallurl() {
        return smallurl;
    }

    public void setSmallurl(String smallurl) {
        this.smallurl = smallurl;
    }

}

