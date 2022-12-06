package com.gautruc.model;

import java.util.List;

public class categoryHomepageClient {
    String nameCategory;
    int Photo;
    List<productHomepageClient> productHomepageClientList;

    public categoryHomepageClient(String nameCategory, int photo, List<productHomepageClient> productHomepageClientList) {
        this.nameCategory = nameCategory;
        Photo = photo;
        this.productHomepageClientList = productHomepageClientList;
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

    public List<productHomepageClient> getProductHomepageClientList() {
        return productHomepageClientList;
    }

    public void setProductHomepageClientList(List<productHomepageClient> productHomepageClientList) {
        this.productHomepageClientList = productHomepageClientList;
    }
}
