package com.gautruc.model;

public class product {
    private int Id;
    private String image;
    private String name;
    private int price;
    private int oldprice;
    private String rate;

    public product(int id, String image, String name, String rate, int price, int oldprice) {
        Id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.oldprice = oldprice;
        this.rate = rate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOldprice() {
        return oldprice;
    }

    public void setOldprice(int oldprice) {
        this.oldprice = oldprice;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
