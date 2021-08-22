
package com.gunaeats.myecommerce.model.categorymodel;

import java.io.Serializable;
import java.util.List;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class CategoryModel implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("response")
    @Expose
    private List<Response> response = null;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<CategoryModel> CREATOR = new Creator<CategoryModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CategoryModel createFromParcel(android.os.Parcel in) {
            return new CategoryModel(in);
        }

        public CategoryModel[] newArray(int size) {
            return (new CategoryModel[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4298565097603278602L;

    protected CategoryModel(android.os.Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.response, (Response.class.getClassLoader()));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CategoryModel() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeList(response);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
