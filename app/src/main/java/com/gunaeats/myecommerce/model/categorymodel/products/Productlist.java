
package com.gunaeats.myecommerce.model.categorymodel.products;

import java.io.Serializable;
import java.util.List;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Productlist implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("response")
    @Expose
    private List<Response> response = null;
    public final static Creator<Productlist> CREATOR = new Creator<Productlist>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Productlist createFromParcel(android.os.Parcel in) {
            return new Productlist(in);
        }

        public Productlist[] newArray(int size) {
            return (new Productlist[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4045408958385088239L;

    protected Productlist(android.os.Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.response, (Response.class.getClassLoader()));
    }

    public Productlist() {
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

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeList(response);
    }

    public int describeContents() {
        return  0;
    }

}
