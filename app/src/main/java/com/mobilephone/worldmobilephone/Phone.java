package com.mobilephone.worldmobilephone;

import java.io.Serializable;

public class Phone implements Serializable {
    private int image;
    private String name;
    private String priceSel;
    private String price;

    public Phone(int image, String name, String priceSel, String price) {
        this.image = image;
        this.name = name;
        this.priceSel = priceSel;
        this.price = price;
    }

    public Phone() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceSel() {
        return priceSel;
    }

    public void setPriceSel(String priceSel) {
        this.priceSel = priceSel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
