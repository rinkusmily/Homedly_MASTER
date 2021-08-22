package com.gunaeats.myecommerce.pojomodel;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

    int catid,PageType;
    String rootid;
    String title;
    String imageurl;
    List<SubCategory> subCategories;
    List<ListItem> productslist;

    public Category(int catid, String title) {
        this.catid = catid;
        this.title = title;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public int getPageType() {
        return PageType;
    }

    public void setPageType(int pageType) {
        PageType = pageType;
    }

    public String getRootid() {
        return rootid;
    }

    public void setRootid(String rootid) {
        this.rootid = rootid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public List<ListItem> getProductslist() {
        return productslist;
    }

    public void setProductslist(List<ListItem> productslist) {
        this.productslist = productslist;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catid=" + catid +
                ", PageType=" + PageType +
                ", rootid='" + rootid + '\'' +
                ", title='" + title + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", subCategories=" + subCategories +
                ", productslist=" + productslist +
                '}';
    }
}
