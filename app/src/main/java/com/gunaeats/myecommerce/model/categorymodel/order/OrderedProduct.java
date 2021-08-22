
package com.gunaeats.myecommerce.model.categorymodel.order;

import java.io.Serializable;
import java.util.List;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class OrderedProduct implements Serializable, Parcelable
{

    @SerializedName("orderid")
    @Expose
    private String orderid;
    @SerializedName("booking_id")
    @Expose
    private String bookingId;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("total_price")
    @Expose
    private String totalPrice;
    @SerializedName("discount_amount")
    @Expose
    private Object discountAmount;
    @SerializedName("total_amount")
    @Expose
    private Object totalAmount;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    public final static Creator<OrderedProduct> CREATOR = new Creator<OrderedProduct>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OrderedProduct createFromParcel(android.os.Parcel in) {
            return new OrderedProduct(in);
        }

        public OrderedProduct[] newArray(int size) {
            return (new OrderedProduct[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4438383141502109878L;

    protected OrderedProduct(android.os.Parcel in) {
        this.orderid = ((String) in.readValue((String.class.getClassLoader())));
        this.bookingId = ((String) in.readValue((String.class.getClassLoader())));
        this.productId = ((String) in.readValue((String.class.getClassLoader())));
        this.qty = ((String) in.readValue((String.class.getClassLoader())));
        this.price = ((String) in.readValue((String.class.getClassLoader())));
        this.totalPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.discountAmount = ((Object) in.readValue((Object.class.getClassLoader())));
        this.totalAmount = ((Object) in.readValue((Object.class.getClassLoader())));
        in.readList(this.products, (Product.class.getClassLoader()));
    }

    public OrderedProduct() {
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Object getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Object discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Object getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Object totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(orderid);
        dest.writeValue(bookingId);
        dest.writeValue(productId);
        dest.writeValue(qty);
        dest.writeValue(price);
        dest.writeValue(totalPrice);
        dest.writeValue(discountAmount);
        dest.writeValue(totalAmount);
        dest.writeList(products);
    }

    public int describeContents() {
        return  0;
    }

}
