package com.gautruc.model;

public class order {
    private String order;
    private String status;
    private float price;

    public order(String order, String status, float price) {
        this.order = order;
        this.status = status;
        this.price = price;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
