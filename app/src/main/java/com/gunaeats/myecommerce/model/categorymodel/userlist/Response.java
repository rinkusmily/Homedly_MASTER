
package com.gunaeats.myecommerce.model.categorymodel.userlist;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Response implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_fname")
    @Expose
    private String userFname;
    @SerializedName("user_lname")
    @Expose
    private String userLname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("avatar")
    @Expose
    private Object avatar;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("verified_status")
    @Expose
    private String verifiedStatus;
    @SerializedName("login_status")
    @Expose
    private Object loginStatus;
    @SerializedName("login_date")
    @Expose
    private Object loginDate;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("otp")
    @Expose
    private String otp;
    @SerializedName("baseurl")
    @Expose
    private String baseurl;
    public final static Creator<Response> CREATOR = new Creator<Response>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Response createFromParcel(android.os.Parcel in) {
            return new Response(in);
        }

        public Response[] newArray(int size) {
            return (new Response[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1257733273310514564L;

    protected Response(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.userFname = ((String) in.readValue((String.class.getClassLoader())));
        this.userLname = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.avatar = ((Object) in.readValue((Object.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
        this.mobile = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.zipcode = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.verifiedStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.loginStatus = ((Object) in.readValue((Object.class.getClassLoader())));
        this.loginDate = ((Object) in.readValue((Object.class.getClassLoader())));
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.otp = ((String) in.readValue((String.class.getClassLoader())));
        this.baseurl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Response() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVerifiedStatus() {
        return verifiedStatus;
    }

    public void setVerifiedStatus(String verifiedStatus) {
        this.verifiedStatus = verifiedStatus;
    }

    public Object getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Object loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Object getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Object loginDate) {
        this.loginDate = loginDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(userFname);
        dest.writeValue(userLname);
        dest.writeValue(email);
        dest.writeValue(avatar);
        dest.writeValue(password);
        dest.writeValue(createdOn);
        dest.writeValue(mobile);
        dest.writeValue(address);
        dest.writeValue(city);
        dest.writeValue(zipcode);
        dest.writeValue(type);
        dest.writeValue(verifiedStatus);
        dest.writeValue(loginStatus);
        dest.writeValue(loginDate);
        dest.writeValue(state);
        dest.writeValue(otp);
        dest.writeValue(baseurl);
    }

    public int describeContents() {
        return  0;
    }

}
