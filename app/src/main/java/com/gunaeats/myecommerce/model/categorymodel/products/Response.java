
package com.gunaeats.myecommerce.model.categorymodel.products;

import java.io.Serializable;
import java.util.List;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Response implements Serializable, Parcelable
{

    @SerializedName("prod_id")
    @Expose
    private String prodId;
    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("prod_title")
    @Expose
    private String prodTitle;
    @SerializedName("prod_title_ar")
    @Expose
    private String prodTitleAr;
    @SerializedName("prod_price")
    @Expose
    private String prodPrice;
    @SerializedName("prod_short_desc")
    @Expose
    private String prodShortDesc;
    @SerializedName("prod_desc")
    @Expose
    private String prodDesc;
    @SerializedName("prod_desc_ar")
    @Expose
    private String prodDescAr;
    @SerializedName("prod_cate_id")
    @Expose
    private String prodCateId;
    @SerializedName("prod_subcate_id")
    @Expose
    private String prodSubcateId;
    @SerializedName("prod_image")
    @Expose
    private Object prodImage;
    @SerializedName("prod_image2")
    @Expose
    private Object prodImage2;
    @SerializedName("prod_image3")
    @Expose
    private Object prodImage3;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("brand_id")
    @Expose
    private String brandId;
    @SerializedName("regions")
    @Expose
    private Object regions;
    @SerializedName("prod_subsubcate_id")
    @Expose
    private String prodSubsubcateId;
    @SerializedName("group")
    @Expose
    private Object group;
    @SerializedName("color")
    @Expose
    private Object color;
    @SerializedName("condition")
    @Expose
    private Object condition;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("rating")
    @Expose
    private Object rating;
    @SerializedName("new_quantity")
    @Expose
    private String newQuantity;
    @SerializedName("model_number")
    @Expose
    private String modelNumber;
    @SerializedName("offer_note")
    @Expose
    private String offerNote;
    @SerializedName("offer_note_ar")
    @Expose
    private String offerNoteAr;
    @SerializedName("shipping_free")
    @Expose
    private Object shippingFree;
    @SerializedName("live_on_site")
    @Expose
    private String liveOnSite;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("offer_price")
    @Expose
    private String offerPrice;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("deal_id")
    @Expose
    private String dealId;
    @SerializedName("deals_active_status")
    @Expose
    private String dealsActiveStatus;
    @SerializedName("sale_price")
    @Expose
    private String salePrice;
    @SerializedName("recomended_p")
    @Expose
    private String recomendedP;
    @SerializedName("thumbnail_image")
    @Expose
    private String thumbnailImage;
    @SerializedName("p_status")
    @Expose
    private String pStatus;
    @SerializedName("start_date_pstr")
    @Expose
    private String startDatePstr;
    @SerializedName("end_date_pstr")
    @Expose
    private String endDatePstr;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("size")
    @Expose
    private List<Size> size = null;
    @SerializedName("brand")
    @Expose
    private Brand brand;
    @SerializedName("seller")
    @Expose
    private List<Seller> seller = null;
    @SerializedName("review")
    @Expose
    private List<Object> review = null;
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
    private final static long serialVersionUID = 7332357734495639827L;

    protected Response(android.os.Parcel in) {
        this.prodId = ((String) in.readValue((String.class.getClassLoader())));
        this.sid = ((String) in.readValue((String.class.getClassLoader())));
        this.prodTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.prodTitleAr = ((String) in.readValue((String.class.getClassLoader())));
        this.prodPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.prodShortDesc = ((String) in.readValue((Object.class.getClassLoader())));
        this.prodDesc = ((String) in.readValue((String.class.getClassLoader())));
        this.prodDescAr = ((String) in.readValue((String.class.getClassLoader())));
        this.prodCateId = ((String) in.readValue((String.class.getClassLoader())));
        this.prodSubcateId = ((String) in.readValue((String.class.getClassLoader())));
        this.prodImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.prodImage2 = ((Object) in.readValue((Object.class.getClassLoader())));
        this.prodImage3 = ((Object) in.readValue((Object.class.getClassLoader())));
        this.stock = ((String) in.readValue((String.class.getClassLoader())));
        this.brandId = ((String) in.readValue((String.class.getClassLoader())));
        this.regions = ((Object) in.readValue((Object.class.getClassLoader())));
        this.prodSubsubcateId = ((String) in.readValue((String.class.getClassLoader())));
        this.group = ((Object) in.readValue((Object.class.getClassLoader())));
        this.color = ((Object) in.readValue((Object.class.getClassLoader())));
        this.condition = ((Object) in.readValue((Object.class.getClassLoader())));
        this.quantity = ((String) in.readValue((String.class.getClassLoader())));
        this.rating = ((Object) in.readValue((Object.class.getClassLoader())));
        this.newQuantity = ((String) in.readValue((String.class.getClassLoader())));
        this.modelNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.offerNote = ((String) in.readValue((String.class.getClassLoader())));
        this.offerNoteAr = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingFree = ((Object) in.readValue((Object.class.getClassLoader())));
        this.liveOnSite = ((String) in.readValue((String.class.getClassLoader())));
        this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.offerPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.endTime = ((String) in.readValue((String.class.getClassLoader())));
        this.dealId = ((String) in.readValue((String.class.getClassLoader())));
        this.dealsActiveStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.salePrice = ((String) in.readValue((String.class.getClassLoader())));
        this.recomendedP = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnailImage = ((String) in.readValue((String.class.getClassLoader())));
        this.pStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.startDatePstr = ((String) in.readValue((String.class.getClassLoader())));
        this.endDatePstr = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.images, (Image.class.getClassLoader()));
        in.readList(this.size, (Size.class.getClassLoader()));
        this.brand = ((Brand) in.readValue((Brand.class.getClassLoader())));
        in.readList(this.seller, (Seller.class.getClassLoader()));
        in.readList(this.review, (Object.class.getClassLoader()));
        this.baseUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Response() {
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getProdTitle() {
        return prodTitle;
    }

    public void setProdTitle(String prodTitle) {
        this.prodTitle = prodTitle;
    }

    public String getProdTitleAr() {
        return prodTitleAr;
    }

    public void setProdTitleAr(String prodTitleAr) {
        this.prodTitleAr = prodTitleAr;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdShortDesc() {
        return prodShortDesc;
    }

    public void setProdShortDesc(String prodShortDesc) {
        this.prodShortDesc = prodShortDesc;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdDescAr() {
        return prodDescAr;
    }

    public void setProdDescAr(String prodDescAr) {
        this.prodDescAr = prodDescAr;
    }

    public String getProdCateId() {
        return prodCateId;
    }

    public void setProdCateId(String prodCateId) {
        this.prodCateId = prodCateId;
    }

    public String getProdSubcateId() {
        return prodSubcateId;
    }

    public void setProdSubcateId(String prodSubcateId) {
        this.prodSubcateId = prodSubcateId;
    }

    public Object getProdImage() {
        return prodImage;
    }

    public void setProdImage(Object prodImage) {
        this.prodImage = prodImage;
    }

    public Object getProdImage2() {
        return prodImage2;
    }

    public void setProdImage2(Object prodImage2) {
        this.prodImage2 = prodImage2;
    }

    public Object getProdImage3() {
        return prodImage3;
    }

    public void setProdImage3(Object prodImage3) {
        this.prodImage3 = prodImage3;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public Object getRegions() {
        return regions;
    }

    public void setRegions(Object regions) {
        this.regions = regions;
    }

    public String getProdSubsubcateId() {
        return prodSubsubcateId;
    }

    public void setProdSubsubcateId(String prodSubsubcateId) {
        this.prodSubsubcateId = prodSubsubcateId;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public Object getCondition() {
        return condition;
    }

    public void setCondition(Object condition) {
        this.condition = condition;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public String getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(String newQuantity) {
        this.newQuantity = newQuantity;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getOfferNote() {
        return offerNote;
    }

    public void setOfferNote(String offerNote) {
        this.offerNote = offerNote;
    }

    public String getOfferNoteAr() {
        return offerNoteAr;
    }

    public void setOfferNoteAr(String offerNoteAr) {
        this.offerNoteAr = offerNoteAr;
    }

    public Object getShippingFree() {
        return shippingFree;
    }

    public void setShippingFree(Object shippingFree) {
        this.shippingFree = shippingFree;
    }

    public String getLiveOnSite() {
        return liveOnSite;
    }

    public void setLiveOnSite(String liveOnSite) {
        this.liveOnSite = liveOnSite;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealsActiveStatus() {
        return dealsActiveStatus;
    }

    public void setDealsActiveStatus(String dealsActiveStatus) {
        this.dealsActiveStatus = dealsActiveStatus;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getRecomendedP() {
        return recomendedP;
    }

    public void setRecomendedP(String recomendedP) {
        this.recomendedP = recomendedP;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public String getStartDatePstr() {
        return startDatePstr;
    }

    public void setStartDatePstr(String startDatePstr) {
        this.startDatePstr = startDatePstr;
    }

    public String getEndDatePstr() {
        return endDatePstr;
    }

    public void setEndDatePstr(String endDatePstr) {
        this.endDatePstr = endDatePstr;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Size> getSize() {
        return size;
    }

    public void setSize(List<Size> size) {
        this.size = size;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Seller> getSeller() {
        return seller;
    }

    public void setSeller(List<Seller> seller) {
        this.seller = seller;
    }

    public List<Object> getReview() {
        return review;
    }

    public void setReview(List<Object> review) {
        this.review = review;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(prodId);
        dest.writeValue(sid);
        dest.writeValue(prodTitle);
        dest.writeValue(prodTitleAr);
        dest.writeValue(prodPrice);
        dest.writeValue(prodShortDesc);
        dest.writeValue(prodDesc);
        dest.writeValue(prodDescAr);
        dest.writeValue(prodCateId);
        dest.writeValue(prodSubcateId);
        dest.writeValue(prodImage);
        dest.writeValue(prodImage2);
        dest.writeValue(prodImage3);
        dest.writeValue(stock);
        dest.writeValue(brandId);
        dest.writeValue(regions);
        dest.writeValue(prodSubsubcateId);
        dest.writeValue(group);
        dest.writeValue(color);
        dest.writeValue(condition);
        dest.writeValue(quantity);
        dest.writeValue(rating);
        dest.writeValue(newQuantity);
        dest.writeValue(modelNumber);
        dest.writeValue(offerNote);
        dest.writeValue(offerNoteAr);
        dest.writeValue(shippingFree);
        dest.writeValue(liveOnSite);
        dest.writeValue(createdOn);
        dest.writeValue(status);
        dest.writeValue(offerPrice);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(startTime);
        dest.writeValue(endTime);
        dest.writeValue(dealId);
        dest.writeValue(dealsActiveStatus);
        dest.writeValue(salePrice);
        dest.writeValue(recomendedP);
        dest.writeValue(thumbnailImage);
        dest.writeValue(pStatus);
        dest.writeValue(startDatePstr);
        dest.writeValue(endDatePstr);
        dest.writeList(images);
        dest.writeList(size);
        dest.writeValue(brand);
        dest.writeList(seller);
        dest.writeList(review);
        dest.writeValue(baseUrl);
    }

    public int describeContents() {
        return  0;
    }

}
