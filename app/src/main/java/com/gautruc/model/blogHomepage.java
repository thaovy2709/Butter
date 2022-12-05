package com.gautruc.model;

public class blogHomepage {
    int photo;
    String date;
    String title;
    String description;

    public blogHomepage(int photo, String date, String title, String description) {
        this.photo = photo;
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
