package com.gautruc.model;

public class eventHomepage {
    int photo;
    String description;

    public eventHomepage(int photo, String description) {
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
