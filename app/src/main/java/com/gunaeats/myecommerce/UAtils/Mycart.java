package com.gunaeats.myecommerce.UAtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Mycart {

    public final static String idouto_ = "autoidid";
    public final static String productid = "pid";
    public final static String productname = "pname";
    public final static String productimage = "pimage";
    public final static String productprice = "pprice";
    public final static String productquantity = "pquantity";
    public final static String productdesp = "ppdesp";
    public final static String shortDescription = "shortDiscription";

    final static String DATABASE_NAME = "OnlineShoppingdb";
    final static String Cart_Table = "CART_TABLE";
    final static int DATABASE_VERSION = 1;
    final static String PRODUCT = "PRODUCT_TABLE";



    final static String DATABASE_CREATE1 = "create table " + PRODUCT + "(" + idouto_ + " integer primary key autoincrement,"
            + productid + " text,"
            + productname + " text,"
            + productimage + " text,"
            + productprice + " text,"
            + productquantity + " text,"
            + productdesp + " text,"
            + shortDescription + " text);";


    private static final String TAG = "Mycart";
    final DatabaseHelper dbHelper;
    final Context context;
    SQLiteDatabase db;



    public Mycart(Context con) {
        this.context = con;
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }
    //-------------------------------------------------//---------------------------------------------------------//
    // TODO 18-02-2020 INSERT DATA CART PRODUCT
    //-------------------------------------------------//---------------------------------------------------------//

    public long insertproduct(String productid, String productname, String productimage, String productprice, String productquantity, String despcription, String shortdiscription ) {

      ContentValues values = new ContentValues();

        values.put(Mycart.productid, productid);
        values.put(Mycart.productname, productname);
        values.put(Mycart.productimage, productimage);
        values.put(Mycart.productprice, productprice);
        values.put(Mycart.productquantity, productquantity);
        values.put(Mycart.productdesp, despcription);
        values.put(Mycart.shortDescription, shortdiscription);

        return db.insert(PRODUCT, null, values);
    }

    //-------------------------------------------------//---------------------------------------------------------//
    // TODO 18-02-2020 UPDATE DATA CART PRODUCT
    //-------------------------------------------------//---------------------------------------------------------//


    public void updateQuantity(String productid, String quantity) {
        ContentValues cv = new ContentValues();
        cv.put(Mycart.productquantity, quantity);
        db.update(PRODUCT, cv, Mycart.productid + "=" + productid, null);
    }

    //-------------------------------------------------//---------------------------------------------------------//
    // TODO 18-02-2020 GETALL DATA CART PRODUCT
    //-------------------------------------------------//---------------------------------------------------------//


    public List<LocalCartModal> getAllProduct() {

        List<LocalCartModal> cartList = new ArrayList<>();
        Cursor c =  db.rawQuery("SELECT * FROM " + PRODUCT ,null);

        if (c.moveToFirst()){
            do {

                String pid = c.getString(c.getColumnIndex(Mycart.productid));
                String pName = c.getString(c.getColumnIndex(Mycart.productname));
                String pImage = c.getString(c.getColumnIndex(Mycart.productimage));
                String pPrice = c.getString(c.getColumnIndex(Mycart.productprice));
                String pQuantity = c.getString(c.getColumnIndex(Mycart.productquantity));
                String pdesp = c.getString(c.getColumnIndex(Mycart.productdesp));
                String pshortdesp = c.getString(c.getColumnIndex(Mycart.shortDescription));

                LocalCartModal cartModal = new LocalCartModal();
                cartModal.setId(pid);
                cartModal.setName(pName);
                cartModal.setImage(pImage);
                cartModal.setPrice(pPrice);
                cartModal.setQuantity(pQuantity);
                cartModal.setDescription(pdesp);
                cartModal.setShortDescription(pshortdesp);

                cartList.add(cartModal);
            }while (c.moveToNext());
        }


       return cartList;
    }

    //-------------------------------------------------//---------------------------------------------------------//
    // TODO 18-02-2020 DELETE ALL DATA CART PRODUCT
    //-------------------------------------------------//---------------------------------------------------------//


    public void geleteAllProduct() {
        // SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(PRODUCT, null, null);
        db.close();
    }


    //-------------------------------------------------//---------------------------------------------------------//
    // TODO 18-02-2020 CHEKAVAILABLITY DATA CART PRODUCT
    //-------------------------------------------------//---------------------------------------------------------//

    public int checkAvailableProduct(String product_id) {
        Cursor cursor = null;
        String sql = "SELECT * FROM " + PRODUCT + " WHERE " + Mycart.productid + "='" + product_id + "'";
        cursor = db.rawQuery(sql, null);


        if (cursor.getCount() > 0) {
            //PID Found
            cursor.close();
            return 1;
        } else {
            //PID Not Found
            cursor.close();
            return 0;
        }
    }

    //-------------------------------------------------//---------------------------------------------------------//
    // TODO 18-02-2020 DELETE  DATA CART PRODUCT
    //-------------------------------------------------//---------------------------------------------------------//

    public boolean deleteproduct(String product_id) {
        return db.delete(PRODUCT, Mycart.productid + "='" + product_id + "'", null) > 0;
    }


    //-------------------------------------------------//---------------------------------------------------------//
    // TODO 18-02-2020 COUNT  DATA CART PRODUCT
    //-------------------------------------------------//---------------------------------------------------------//

    public long countproduct() {

        long count = DatabaseUtils.queryNumEntries(db, PRODUCT);

        return count;
    }



    public double gettotalProductPrice() {

        double finalPrice = 0.0;
        Cursor c =  db.rawQuery("SELECT * FROM " + PRODUCT ,null);
        if (c.getColumnCount()>0){


            if (c.moveToFirst()){
                do {

                    String quantity = c.getString(c.getColumnIndex(Mycart.productquantity));
                    String strprice = c.getString(c.getColumnIndex(Mycart.productprice));
                    int quant = Integer.parseInt(quantity);
                    double price =  Double.parseDouble(strprice);
                    finalPrice = finalPrice+price*quant;

                }while (c.moveToNext());
            }

        }

    return finalPrice;

    }





    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            try {
                database.execSQL(DATABASE_CREATE1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);


            onCreate(db);
        }
    }


}

