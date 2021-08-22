
package com.gunaeats.myecommerce.model.categorymodel.subcategory;

import java.io.Serializable;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Response implements Serializable, Parcelable
{

    @SerializedName("sub_category_id")
    @Expose
    private String subCategoryId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("ar_sub_category_name")
    @Expose
    private String arSubCategoryName;
    @SerializedName("subcate_image")
    @Expose
    private String subcateImage;
    @SerializedName("base_url")
    @Expose
    private String baseUrl;
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
    private final static long serialVersionUID = -1409875898193348301L;

    protected Response(android.os.Parcel in) {
        this.subCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.categoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.subCategoryName = ((String) in.readValue((String.class.getClassLoader())));
        this.arSubCategoryName = ((String) in.readValue((String.class.getClassLoader())));
        this.subcateImage = ((String) in.readValue((String.class.getClassLoader())));
        this.baseUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Response() {
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getArSubCategoryName() {
        return arSubCategoryName;
    }

    public void setArSubCategoryName(String arSubCategoryName) {
        this.arSubCategoryName = arSubCategoryName;
    }

    public String getSubcateImage() {
        return subcateImage;
    }

    public void setSubcateImage(String subcateImage) {
        this.subcateImage = subcateImage;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(subCategoryId);
        dest.writeValue(categoryId);
        dest.writeValue(subCategoryName);
        dest.writeValue(arSubCategoryName);
        dest.writeValue(subcateImage);
        dest.writeValue(baseUrl);
    }

    public int describeContents() {
        return  0;
    }

}
