package com.gunaeats.myecommerce.pojomodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AddressModel implements Serializable {

    boolean isSelected=false;

    @SerializedName("tcdid")
    @Expose
    private String tcdid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("latitude")
    @Expose
    private String latitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @SerializedName("longitude")
    @Expose
    private String longitude;

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

    @SerializedName("addresstype")
    @Expose
    private String addresstype;

    private final static long serialVersionUID = 4344048026600274245L;

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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }
}
