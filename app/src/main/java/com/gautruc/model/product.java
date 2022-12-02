package com.gautruc.model;

public class product {
    private int Id;
    private String image;
    private String name;
    private Double price;
    private Double oldprice;
    private String rate;

    public product(int id, String image, String name, Double price, Double oldprice, String rate) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldprice() {
        return oldprice;
    }

    public void setOldprice(Double oldprice) {
        this.oldprice = oldprice;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
