package com.gautruc.model;

public class StoreList {
    int storeListThumb;
    String storeListName;
    String storeListAddress;
    String storeListPhone;
    String storeListOpenTime;

    public StoreList(int storeListThumb, String storeListName, String storeListAddress, String storeListPhone, String storeListOpenTime) {
        this.storeListThumb = storeListThumb;
        this.storeListName = storeListName;
        this.storeListAddress = storeListAddress;
        this.storeListPhone = storeListPhone;
        this.storeListOpenTime = storeListOpenTime;
    }

    public int getStoreListThumb() {
        return storeListThumb;
    }

    public void setStoreListThumb(int storeListThumb) {
        this.storeListThumb = storeListThumb;
    }

    public String getStoreListName() {
        return storeListName;
    }

    public void setStoreListName(String storeListName) {
        this.storeListName = storeListName;
    }

    public String getStoreListAddress() {
        return storeListAddress;
    }

    public void setStoreListAddress(String storeListAddress) {
        this.storeListAddress = storeListAddress;
    }

    public String getStoreListPhone() {
        return storeListPhone;
    }

    public void setStoreListPhone(String storeListPhone) {
        this.storeListPhone = storeListPhone;
    }

    public String getStoreListOpenTime() {
        return storeListOpenTime;
    }

    public void setStoreListOpenTime(String storeListOpenTime) {
        this.storeListOpenTime = storeListOpenTime;
    }
}
