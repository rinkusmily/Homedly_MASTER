package com.gunaeats.myecommerce.pojomodel;

public class CartModel {
    private int id,pro_id,cat_id,sub_cat_id,brandid,price,quantity,v_price;
    private String image,name,brand,desc,prdcode,variant;

    public CartModel() {
    }

    public CartModel(int pro_id, int cat_id, int sub_cat_id, int brandid, int price, int quantity, String image, String name, String brand, String desc, String variant,int v_price) {
        this.pro_id = pro_id;
        this.cat_id = cat_id;
        this.sub_cat_id = sub_cat_id;
        this.brandid = brandid;
        this.price = price;
        this.quantity = quantity;
        this.v_price = v_price;
        this.image = image;
        this.name = name;
        this.brand = brand;
        this.desc = desc;
        this.variant = variant;
        this.v_price = v_price;
    }

    public CartModel(int id, int pro_id, int cat_id, int sub_cat_id, int brandid, int price, int quantity, String image, String name, String brand, String desc, String prdcode, String variant,int v_price) {
        this.id = id;
        this.pro_id = pro_id;
        this.cat_id = cat_id;
        this.sub_cat_id = sub_cat_id;
        this.brandid = brandid;
        this.price = price;
        this.quantity = quantity;
        this.v_price = v_price;
        this.image = image;
        this.name = name;
        this.brand = brand;
        this.desc = desc;
        this.prdcode = prdcode;
        this.variant = variant;
        this.v_price = v_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getSub_cat_id() {
        return sub_cat_id;
    }

    public void setSub_cat_id(int sub_cat_id) {
        this.sub_cat_id = sub_cat_id;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrdcode() {
        return prdcode;
    }

    public void setPrdcode(String prdcode) {
        this.prdcode = prdcode;
    }

    public int getV_price() {
        return v_price;
    }

    public void setV_price(int v_price) {
        this.v_price = v_price;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    @Override
    public String toString() {
        return "CartModel{" +
                "id=" + id +
                ", pro_id=" + pro_id +
                ", cat_id=" + cat_id +
                ", sub_cat_id=" + sub_cat_id +
                ", brandid=" + brandid +
                ", price=" + price +
                ", quantity=" + quantity +
                ", v_price=" + v_price +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", desc='" + desc + '\'' +
                ", prdcode='" + prdcode + '\'' +
                ", variant='" + variant + '\'' +
                '}';
    }
}

