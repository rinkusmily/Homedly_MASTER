
package com.gunaeats.myecommerce.model.categorymodel.order;

import java.io.Serializable;
import java.util.List;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Product implements Serializable, Parcelable
{

    @SerializedName("prod_id")
    @Expose
    private String prodId;
    @SerializedName("prod_title")
    @Expose
    private String prodTitle;
    @SerializedName("prod_price")
    @Expose
    private String prodPrice;
    @SerializedName("prod_desc")
    @Expose
    private String prodDesc;
    @SerializedName("prod_cate_id")
    @Expose
    private String prodCateId;
    @SerializedName("prod_subcate_id")
    @Expose
    private String prodSubcateId;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("new_quantity")
    @Expose
    private String newQuantity;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sale_price")
    @Expose
    private String salePrice;
    @SerializedName("thumbnail_image")
    @Expose
    private String thumbnailImage;
    @SerializedName("p_status")
    @Expose
    private String pStatus;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    public final static Creator<Product> CREATOR = new Creator<Product>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Product createFromParcel(android.os.Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return (new Product[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2335158080006242986L;

    protected Product(android.os.Parcel in) {
        this.prodId = ((String) in.readValue((String.class.getClassLoader())));
        this.prodTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.prodPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.prodDesc = ((String) in.readValue((String.class.getClassLoader())));
        this.prodCateId = ((String) in.readValue((String.class.getClassLoader())));
        this.prodSubcateId = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((String) in.readValue((String.class.getClassLoader())));
        this.newQuantity = ((String) in.readValue((String.class.getClassLoader())));
        this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.salePrice = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnailImage = ((String) in.readValue((String.class.getClassLoader())));
        this.pStatus = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.images, (Image.class.getClassLoader()));
    }

    public Product() {
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdTitle() {
        return prodTitle;
    }

    public void setProdTitle(String prodTitle) {
        this.prodTitle = prodTitle;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdCateId() {
        return prodCateId;
    }

    public void setProdCateId(String prodCateId) {
        this.prodCateId = prodCateId;
    }

    public String getProdSubcateId() {
        return prodSubcateId;
    }

    public void setProdSubcateId(String prodSubcateId) {
        this.prodSubcateId = prodSubcateId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(String newQuantity) {
        this.newQuantity = newQuantity;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(prodId);
        dest.writeValue(prodTitle);
        dest.writeValue(prodPrice);
        dest.writeValue(prodDesc);
        dest.writeValue(prodCateId);
        dest.writeValue(prodSubcateId);
        dest.writeValue(quantity);
        dest.writeValue(newQuantity);
        dest.writeValue(createdOn);
        dest.writeValue(status);
        dest.writeValue(salePrice);
        dest.writeValue(thumbnailImage);
        dest.writeValue(pStatus);
        dest.writeList(images);
    }

    public int describeContents() {
        return  0;
    }

}
