
package com.gunaeats.myecommerce.model.categorymodel;

import java.io.Serializable;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Response implements Serializable, Parcelable
{

    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("ar_category_name")
    @Expose
    private String arCategoryName;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("color_name")
    @Expose
    private Object colorName;
    @SerializedName("icon_name")
    @Expose
    private Object iconName;
    @SerializedName("publication_status")
    @Expose
    private Object publicationStatus;
    @SerializedName("deletion_status")
    @Expose
    private String deletionStatus;
    @SerializedName("date_added")
    @Expose
    private Object dateAdded;
    @SerializedName("last_updated")
    @Expose
    private Object lastUpdated;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("subcategory count")
    @Expose
    private Integer subcategoryCount;
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
    private final static long serialVersionUID = 1781533387259922723L;

    protected Response(android.os.Parcel in) {
        this.categoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.categoryName = ((String) in.readValue((String.class.getClassLoader())));
        this.arCategoryName = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((Object) in.readValue((Object.class.getClassLoader())));
        this.colorName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.iconName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.publicationStatus = ((Object) in.readValue((Object.class.getClassLoader())));
        this.deletionStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.dateAdded = ((Object) in.readValue((Object.class.getClassLoader())));
        this.lastUpdated = ((Object) in.readValue((Object.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.subcategoryCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.baseUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Response() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getArCategoryName() {
        return arCategoryName;
    }

    public void setArCategoryName(String arCategoryName) {
        this.arCategoryName = arCategoryName;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getColorName() {
        return colorName;
    }

    public void setColorName(Object colorName) {
        this.colorName = colorName;
    }

    public Object getIconName() {
        return iconName;
    }

    public void setIconName(Object iconName) {
        this.iconName = iconName;
    }

    public Object getPublicationStatus() {
        return publicationStatus;
    }

    public void setPublicationStatus(Object publicationStatus) {
        this.publicationStatus = publicationStatus;
    }

    public String getDeletionStatus() {
        return deletionStatus;
    }

    public void setDeletionStatus(String deletionStatus) {
        this.deletionStatus = deletionStatus;
    }

    public Object getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Object dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Object getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Object lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSubcategoryCount() {
        return subcategoryCount;
    }

    public void setSubcategoryCount(Integer subcategoryCount) {
        this.subcategoryCount = subcategoryCount;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(categoryId);
        dest.writeValue(userId);
        dest.writeValue(categoryName);
        dest.writeValue(arCategoryName);
        dest.writeValue(description);
        dest.writeValue(colorName);
        dest.writeValue(iconName);
        dest.writeValue(publicationStatus);
        dest.writeValue(deletionStatus);
        dest.writeValue(dateAdded);
        dest.writeValue(lastUpdated);
        dest.writeValue(image);
        dest.writeValue(subcategoryCount);
        dest.writeValue(baseUrl);
    }

    public int describeContents() {
        return  0;
    }

}
