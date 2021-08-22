package com.gunaeats.myecommerce.pojomodel;

import java.io.Serializable;

public class SubCategory implements Serializable {

    public String title,image,subcatname,imageurl,parentId;
    public int subcatid,parentid;
    public  String rootid;

    public SubCategory(String subcatname, String imageurl, int subcatid, int parentid) {
        this.subcatname = subcatname;
        this.imageurl = imageurl;
        this.subcatid = subcatid;
        this.rootid = rootid;
        this.parentid = parentid;
    }

    public SubCategory(String title, String rootid, String parentId, String image) {
        this.title = title;
        this.rootid = rootid;
        this.image=image;
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getSubcatid() {
        return subcatid;
    }

    public void setSubcatid(int subcatid) {
        this.subcatid = subcatid;
    }


    public String getRootid() {
        return rootid;
    }

    public void setRootid(String rootid) {
        this.rootid = rootid;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

