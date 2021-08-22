package com.gunaeats.myecommerce.pojomodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderDetailModel implements Serializable
{

    @SerializedName("custid")
    @Expose
    private String custid;
    @SerializedName("custname")
    @Expose
    private String custname;
    @SerializedName("partnerid")
    @Expose
    private Integer partnerid;
    @SerializedName("partnername")
    @Expose
    private String partnername;
    @SerializedName("orderid")
    @Expose
    private String orderid;
    @SerializedName("orderdate1")
    @Expose
    private String orderdate1;
    @SerializedName("servicedate1")
    @Expose
    private String servicedate1;
    @SerializedName("servicetime1")
    @Expose
    private String servicetime1;
    @SerializedName("status1")
    @Expose
    private String status1;
    @SerializedName("completedate1")
    @Expose
    private Object completedate;
    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("deliverycharge")
    @Expose
    private String deliverycharge;

    @SerializedName("discount")
    @Expose
    private String discount;

    @SerializedName("totalamount")
    @Expose
    private String totalamount;

    @SerializedName("ordertype")
    @Expose
    private String ordertype;

    @SerializedName("ispayment")
    @Expose
    private Integer ispayment;

    @SerializedName("isstarted")
    @Expose
    private String isstarted;

    @SerializedName("awaitingconfirmation")
    @Expose
    private String awaitingconfirmation;

    @SerializedName("IsReviewCustomer")
    @Expose
    private String IsReviewCustomer;

    public String getIsReviewCustomer() {
        return IsReviewCustomer;
    }

    public void setIsReviewCustomer(String isReviewCustomer) {
        IsReviewCustomer = isReviewCustomer;
    }

    public String getIsstarted() {
        return isstarted;
    }

    public void setIsstarted(String isstarted) {
        this.isstarted = isstarted;
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

    public Integer getIspayment() {
        return ispayment;
    }

    public void setIspayment(Integer ispayment) {
        this.ispayment = ispayment;
    }

    public String getAwaitingconfirmation() {
        return awaitingconfirmation;
    }

    public void setAwaitingconfirmation(String awaitingconfirmation) {
        this.awaitingconfirmation = awaitingconfirmation;
    }

    @SerializedName("OrderDetails")
    @Expose
    private List<OrderDetailView> orderDetails = null;



    public List<OrderCancel> getOrderCancel() {
        return orderCancel;
    }

    public void setOrderCancel(List<OrderCancel> orderCancel) {
        this.orderCancel = orderCancel;
    }

    @SerializedName("OrderCancel")
    @Expose
    private List<OrderCancel> orderCancel = null;



    @SerializedName("OrderAddress")
    @Expose
    private List<OrderAddress> orderAddress = null;

    @SerializedName("Partner")
    @Expose
    private List<PartnerDetails> partnerDetails = null;

    private final static long serialVersionUID = -5712415071021492747L;

    public String getDeliverycharge() {
        return deliverycharge;
    }

    public void setDeliverycharge(String deliverycharge) {
        this.deliverycharge = deliverycharge;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public Integer getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(Integer partnerid) {
        this.partnerid = partnerid;
    }

    public String getPartnername() {
        return partnername;
    }

    public void setPartnername(String partnername) {
        this.partnername = partnername;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderdate1() {
        return orderdate1;
    }

    public void setOrderdate1(String orderdate1) {
        this.orderdate1 = orderdate1;
    }

    public String getServicedate1() {
        return servicedate1;
    }

    public void setServicedate1(String servicedate1) {
        this.servicedate1 = servicedate1;
    }

    public String getServicetime1() {
        return servicetime1;
    }

    public void setServicetime1(String servicetime1) {
        this.servicetime1 = servicetime1;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public Object getCompletedate() {
        return completedate;
    }

    public void setCompletedate(Object completedate) {
        this.completedate = completedate;
    }

    public List<OrderDetailView> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailView> orderDetails) {
        this.orderDetails = orderDetails;
    }


    public List<OrderAddress> getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(List<OrderAddress> orderAddress) {
        this.orderAddress = orderAddress;
    }

    public List<PartnerDetails> getPartnerDetails() {
        return partnerDetails;
    }

    public void setPartnerDetails(List<PartnerDetails> partnerDetails) {
        this.partnerDetails = partnerDetails;
    }

    public class OrderAddress implements Serializable
    {

        @SerializedName("tcdid")
        @Expose
        private String tcdid;
        @SerializedName("custid")
        @Expose
        private String custid;
        @SerializedName("pincode")
        @Expose
        private String pincode;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("city")
        @Expose
        private String city;

        @SerializedName("cityid")
        @Expose
        private String cityid;

        @SerializedName("addresstype")
        @Expose
        private String addresstype;

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("mobile")
        @Expose
        private String mobile;

        @SerializedName("state")
        @Expose
        private String state;

        @SerializedName("country")
        @Expose
        private String country;

        private final static long serialVersionUID = -1873838286159419250L;

        public String getTcdid() {
            return tcdid;
        }

        public void setTcdid(String tcdid) {
            this.tcdid = tcdid;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddresstype() {
            return addresstype;
        }

        public void setAddresstype(String addresstype) {
            this.addresstype = addresstype;
        }

        public String getCustid() {
            return custid;
        }

        public void setCustid(String custid) {
            this.custid = custid;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    public class PartnerDetails implements Serializable{

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("emailid")
        @Expose
        private String emailid;
        @SerializedName("imageurl")
        @Expose
        private String imageurl;
        @SerializedName("AToken")
        private String AToken;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmailid() {
            return emailid;
        }

        public void setEmailid(String emailid) {
            this.emailid = emailid;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public String getAToken() {
            return AToken;
        }

        public void setAToken(String AToken) {
            this.AToken = AToken;
        }
    }
}
