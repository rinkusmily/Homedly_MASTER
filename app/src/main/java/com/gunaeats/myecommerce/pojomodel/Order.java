package com.gunaeats.myecommerce.pojomodel;

public class Order {
    String orderid,title,orderdate1,status1,smlimageurl,price,ordertype,awaitingconfirmation;

    public Order() {
    }

    public Order(String orderid, String title, String orderdate1, String status1, String smlimageurl, String price, String ordertype, String awaitingconfirmation) {
        this.orderid = orderid;
        this.title = title;
        this.orderdate1 = orderdate1;
        this.status1 = status1;
        this.smlimageurl = smlimageurl;
        this.price = price;
        this.ordertype = ordertype;
        this.awaitingconfirmation = awaitingconfirmation;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrderdate1() {
        return orderdate1;
    }

    public void setOrderdate1(String orderdate1) {
        this.orderdate1 = orderdate1;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getSmlimageurl() {
        return smlimageurl;
    }

    public void setSmlimageurl(String smlimageurl) {
        this.smlimageurl = smlimageurl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getAwaitingconfirmation() {
        return awaitingconfirmation;
    }

    public void setAwaitingconfirmation(String awaitingconfirmation) {
        this.awaitingconfirmation = awaitingconfirmation;
    }
}

