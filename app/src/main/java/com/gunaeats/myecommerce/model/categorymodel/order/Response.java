
package com.gunaeats.myecommerce.model.categorymodel.order;

import java.io.Serializable;
import java.util.List;

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
    @SerializedName("userfname")
    @Expose
    private String userfname;
    @SerializedName("userphone")
    @Expose
    private String userphone;
    @SerializedName("useremail")
    @Expose
    private String useremail;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("postalcode")
    @Expose
    private String postalcode;
    @SerializedName("payment_method")
    @Expose
    private String paymentMethod;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("booked_id")
    @Expose
    private String bookedId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("shipping_status")
    @Expose
    private String shippingStatus;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("confirm_status")
    @Expose
    private Integer confirmStatus;
    @SerializedName("houseno")
    @Expose
    private String houseno;
    @SerializedName("society")
    @Expose
    private String society;
    @SerializedName("ordered_products")
    @Expose
    private List<OrderedProduct> orderedProducts = null;
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
    private final static long serialVersionUID = -6574228193398208407L;

    protected Response(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.userfname = ((String) in.readValue((String.class.getClassLoader())));
        this.userphone = ((String) in.readValue((String.class.getClassLoader())));
        this.useremail = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.postalcode = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentMethod = ((String) in.readValue((String.class.getClassLoader())));
        this.total = ((String) in.readValue((String.class.getClassLoader())));
        this.bookedId = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.landmark = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.year = ((String) in.readValue((String.class.getClassLoader())));
        this.confirmStatus = ((Integer) in.readValue((String.class.getClassLoader())));
        this.houseno = ((String) in.readValue((String.class.getClassLoader())));
        this.society = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.orderedProducts, (OrderedProduct.class.getClassLoader()));
    }

    public Response() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserfname() {
        return userfname;
    }

    public void setUserfname(String userfname) {
        this.userfname = userfname;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getBookedId() {
        return bookedId;
    }

    public void setBookedId(String bookedId) {
        this.bookedId = bookedId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(userfname);
        dest.writeValue(userphone);
        dest.writeValue(useremail);
        dest.writeValue(city);
        dest.writeValue(address);
        dest.writeValue(postalcode);
        dest.writeValue(paymentMethod);
        dest.writeValue(total);
        dest.writeValue(bookedId);
        dest.writeValue(userId);
        dest.writeValue(landmark);
        dest.writeValue(date);
        dest.writeValue(paymentStatus);
        dest.writeValue(shippingStatus);
        dest.writeValue(year);
        dest.writeValue(confirmStatus);
        dest.writeValue(houseno);
        dest.writeValue(society);
        dest.writeList(orderedProducts);
    }

    public int describeContents() {
        return  0;
    }

}
