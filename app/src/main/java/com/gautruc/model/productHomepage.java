package com.gautruc.model;

public class productHomepage {
    private static int photo;
    private static String name;
    private static String rating;
    private static String stock;
    private static double price;
    private static double oldPrice;

    public productHomepage(int photo, String name, String rating, String stock, double price, double oldPrice) {
        this.photo = photo;
        this.name = name;
        this.rating = rating;
        this.stock = stock;
        this.price = price;
        this.oldPrice = oldPrice;
    }

    public static int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public static String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public static double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }
}
