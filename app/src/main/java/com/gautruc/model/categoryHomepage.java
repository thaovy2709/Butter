package com.gautruc.model;

import com.gautruc.adapter.productHomepageAdapter;

import java.util.List;

public class categoryHomepage {
    String nameCategory;
    int Photo;
    List<productHomepage> productHomepageList;

    public categoryHomepage(String nameCategory, int photo, List<productHomepage> productHomepageList) {
        this.nameCategory = nameCategory;
        Photo = photo;
        this.productHomepageList = productHomepageList;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public List<productHomepage> getProductHomepageList() {
        return productHomepageList;
    }

    public void setProductHomepageList(List<productHomepage> productHomepageList) {
        this.productHomepageList = productHomepageList;
    }
}
