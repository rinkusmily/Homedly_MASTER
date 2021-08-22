package com.gunaeats.myecommerce.pojomodel;

import java.io.Serializable;

public class ListItem implements Serializable {

    String title,description,price,imageurl,brand,prdcode,catname,subcatname,issupercart_str,pricevar,variantvar;
    int PrdId,brandid,catid,subcatid;



   /* public ListItem(String title, String description, String price, String imageurl,int prdId, int brandid, int catid, int subcatid, String brand, String prdcode) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageurl = imageurl;
        this.brand = brand;
        this.prdcode = prdcode;
        PrdId = prdId;
        this.brandid = brandid;
        this.catid = catid;
        this.subcatid = subcatid;
    }*/

    public ListItem(String title, String description, String price, String imageurl, String brand, String prdcode, String catname, String subcatname,String pricevar,String variantvar,String issupercart_str, int prdId, int brandid, int catid, int subcatid) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageurl = imageurl;
        this.brand = brand;
        this.prdcode = prdcode;
        this.catname = catname;
        this.subcatname = subcatname;
        this.pricevar = pricevar;
        this.variantvar = variantvar;
        this.issupercart_str = issupercart_str;
        this.PrdId = prdId;
        this.brandid = brandid;
        this.catid = catid;
        this.subcatid = subcatid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getPrdId() {
        return PrdId;
    }

    public void setPrdId(int prdId) {
        PrdId = prdId;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public int getSubcatid() {
        return subcatid;
    }

    public void setSubcatid(int subcatid) {
        this.subcatid = subcatid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrdcode() {
        return prdcode;
    }

    public void setPrdcode(String prdcode) {
        this.prdcode = prdcode;
    }


    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public String getIssupercart_str() {
        return issupercart_str;
    }

    public void setIssupercart_str(String issupercart_str) {
        this.issupercart_str = issupercart_str;
    }

    public String getPricevar() {
        return pricevar;
    }

    public void setPricevar(String pricevar) {
        this.pricevar = pricevar;
    }

    public String getVariantvar() {
        return variantvar;
    }

    public void setVariantvar(String variantvar) {
        this.variantvar = variantvar;
    }
}
