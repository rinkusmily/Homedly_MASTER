
package com.gunaeats.myecommerce.model.categorymodel.order;

import java.io.Serializable;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Image implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("uploaded_on")
    @Expose
    private String uploadedOn;
    @SerializedName("prod_id")
    @Expose
    private String prodId;
    @SerializedName("is_image")
    @Expose
    private Object isImage;
    public final static Creator<Image> CREATOR = new Creator<Image>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Image createFromParcel(android.os.Parcel in) {
            return new Image(in);
        }

        public Image[] newArray(int size) {
            return (new Image[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3407230384974761331L;

    protected Image(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.uploadedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.prodId = ((String) in.readValue((String.class.getClassLoader())));
        this.isImage = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Image() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(String uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public Object getIsImage() {
        return isImage;
    }

    public void setIsImage(Object isImage) {
        this.isImage = isImage;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(image);
        dest.writeValue(uploadedOn);
        dest.writeValue(prodId);
        dest.writeValue(isImage);
    }

    public int describeContents() {
        return  0;
    }

}
