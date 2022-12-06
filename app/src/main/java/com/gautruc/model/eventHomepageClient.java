package com.gautruc.model;

public class eventHomepageClient {
    int photo;
    String description;

    public eventHomepageClient(int photo, String description) {
        this.photo = photo;
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
