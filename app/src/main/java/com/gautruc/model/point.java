package com.gautruc.model;

public class point {
    private String time;
    private String orderID;
    private int numberpoint;

    public point(String time, String orderID, int numberpoint) {
        this.time = time;
        this.orderID = orderID;
        this.numberpoint = numberpoint;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getNumberpoint() {
        return numberpoint;
    }

    public void setNumberpoint(int numberpoint) {
        this.numberpoint = numberpoint;
    }
}


