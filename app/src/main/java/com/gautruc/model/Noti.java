package com.gautruc.model;

public class Noti {
    int resourceID;
    String txtnameNoti, txtdetailNoti, txttimeNoti;

    public Noti(int resourceID, String txtnameNoti, String txtdetailNoti, String txttimeNoti) {
        this.resourceID = resourceID;
        this.txtnameNoti = txtnameNoti;
        this.txtdetailNoti = txtdetailNoti;
        this.txttimeNoti = txttimeNoti;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getTxtnameNoti() {
        return txtnameNoti;
    }

    public void setTxtnameNoti(String txtnameNoti) {
        this.txtnameNoti = txtnameNoti;
    }

    public String getTxtdetailNoti() {
        return txtdetailNoti;
    }

    public void setTxtdetailNoti(String txtdetailNoti) {
        this.txtdetailNoti = txtdetailNoti;
    }

    public String getTxttimeNoti() {
        return txttimeNoti;
    }

    public void setTxttimeNoti(String txttimeNoti) {
        this.txttimeNoti = txttimeNoti;
    }
}
