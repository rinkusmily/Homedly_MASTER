
package com.gunaeats.myecommerce.model.categorymodel.userlist;

import java.io.Serializable;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserLst implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<UserLst> CREATOR = new Creator<UserLst>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserLst createFromParcel(android.os.Parcel in) {
            return new UserLst(in);
        }

        public UserLst[] newArray(int size) {
            return (new UserLst[size]);
        }

    }
    ;
    private final static long serialVersionUID = 957809282915492244L;

    protected UserLst(android.os.Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.response = ((Response) in.readValue((Response.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserLst() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
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
        dest.writeValue(response);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
