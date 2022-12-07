package com.gautruc.model;

public class productCheckout {
    private int photo;
    private String name;
    private double price;
    private double oldPrice;
    private int productQuantity;

    public productCheckout(int photo, String name, double price, double oldPrice, int productQuantity) {
        this.photo = photo;
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.productQuantity = productQuantity;
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

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
