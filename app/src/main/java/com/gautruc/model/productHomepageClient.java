package com.gautruc.model;

public class productHomepageClient {
    private int photo;
    private String name;
    private String rating;
    private String stock;
    private double price;
    private double oldPrice;

    public productHomepageClient(int photo, String name, String rating, String stock, double price, double oldPrice) {
        this.photo = photo;
        this.name = name;
        this.rating = rating;
        this.stock = stock;
        this.price = price;
        this.oldPrice = oldPrice;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }
}
