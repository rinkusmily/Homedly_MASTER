
package com.gunaeats.myecommerce.model.categorymodel.products;

import java.io.Serializable;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Size implements Serializable, Parcelable
{

    @SerializedName("size_id")
    @Expose
    private String sizeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ar_name")
    @Expose
    private String arName;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("sold_qty")
    @Expose
    private String soldQty;
    @SerializedName("prod_id")
    @Expose
    private String prodId;
    public final static Creator<Size> CREATOR = new Creator<Size>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Size createFromParcel(android.os.Parcel in) {
            return new Size(in);
        }

        public Size[] newArray(int size) {
            return (new Size[size]);
        }

    }
    ;
    private final static long serialVersionUID = 396055282539426875L;

    protected Size(android.os.Parcel in) {
        this.sizeId = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.arName = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.size = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.soldQty = ((String) in.readValue((String.class.getClassLoader())));
        this.prodId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Size() {
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(String soldQty) {
        this.soldQty = soldQty;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(sizeId);
        dest.writeValue(name);
        dest.writeValue(arName);
        dest.writeValue(id);
        dest.writeValue(size);
        dest.writeValue(quantity);
        dest.writeValue(soldQty);
        dest.writeValue(prodId);
    }

    public int describeContents() {
        return  0;
    }

}
