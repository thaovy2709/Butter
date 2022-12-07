package com.gautruc.model;

public class FavoriteDish {
    private int Dish;
    private String rate, priceSale, price, nameDish, quality;

    public FavoriteDish(int dish, String rate, String priceSale, String price, String nameDish, String quality) {
        Dish = dish;
        this.rate = rate;
        this.priceSale = priceSale;
        this.price = price;
        this.nameDish = nameDish;
        this.quality = quality;
    }

    public int getDish() {
        return Dish;
    }

    public void setDish(int dish) {
        Dish = dish;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(String priceSale) {
        this.priceSale = priceSale;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}

