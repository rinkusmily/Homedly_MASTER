
package com.gunaeats.myecommerce.model.categorymodel.products;

import java.io.Serializable;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Brand implements Serializable, Parcelable
{

    @SerializedName("brand_id")
    @Expose
    private String brandId;
    @SerializedName("brand_title")
    @Expose
    private String brandTitle;
    @SerializedName("ar_brand_title")
    @Expose
    private String arBrandTitle;
    @SerializedName("brand_image")
    @Expose
    private String brandImage;
    public final static Creator<Brand> CREATOR = new Creator<Brand>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Brand createFromParcel(android.os.Parcel in) {
            return new Brand(in);
        }

        public Brand[] newArray(int size) {
            return (new Brand[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7406397792437131220L;

    protected Brand(android.os.Parcel in) {
        this.brandId = ((String) in.readValue((String.class.getClassLoader())));
        this.brandTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.arBrandTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.brandImage = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Brand() {
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandTitle() {
        return brandTitle;
    }

    public void setBrandTitle(String brandTitle) {
        this.brandTitle = brandTitle;
    }

    public String getArBrandTitle() {
        return arBrandTitle;
    }

    public void setArBrandTitle(String arBrandTitle) {
        this.arBrandTitle = arBrandTitle;
    }

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(brandId);
        dest.writeValue(brandTitle);
        dest.writeValue(arBrandTitle);
        dest.writeValue(brandImage);
    }

    public int describeContents() {
        return  0;
    }

}
