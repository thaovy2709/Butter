package com.gautruc.model;

public class search {

    private int image;
    private String productName;
    private String productIngredient;
    private String productPrice;

    public search(int image, String productName, String productIngredient, String productPrice) {
        this.image = image;
        this.productName = productName;
        this.productIngredient = productIngredient;
        this.productPrice = productPrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductIngredient() {
        return productIngredient;
    }

    public void setProductIngredient(String productIngredient) {
        this.productIngredient = productIngredient;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {

        this.productPrice = productPrice;
    }
}
