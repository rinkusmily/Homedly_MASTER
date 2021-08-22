package com.gunaeats.myecommerce.serverconnection;

public interface ServerRespondingListener {

    public  void onResponse(String result);
    public  void onError(String error);

}
