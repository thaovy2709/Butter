package com.gautruc.model;

public class Offer {
    int offerThumb;
    String offerInfo;
    int offerPoint;

    public Offer(int offerThumb, String offerInfo, int offerPoint) {
        this.offerThumb = offerThumb;
        this.offerInfo = offerInfo;
        this.offerPoint = offerPoint;
    }

    public int getOfferThumb() {
        return offerThumb;
    }

    public void setOfferThumb(int offerThumb) {
        this.offerThumb = offerThumb;
    }

    public String getOfferInfo() {
        return offerInfo;
    }

    public void setOfferInfo(String offerInfo) {
        this.offerInfo = offerInfo;
    }

    public double getOfferPoint() {
        return offerPoint;
    }

    public void setOfferPoint(int offerPoint) {
        this.offerPoint = offerPoint;
    }
}
