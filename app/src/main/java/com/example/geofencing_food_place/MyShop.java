package com.example.geofencing_food_place;

public class MyShop {

    String shopname,Mobileno,Address,Product1,Offer1,Product2,offer2,lati,longi,imageurl;


    public MyShop() {
    }

    public MyShop(String shopname, String mobileno, String address, String product1, String offer1, String product2, String offer2, String lati, String longi, String imageurl) {
        this.shopname = shopname;
        Mobileno = mobileno;
        Address = address;
        Product1 = product1;
        Offer1 = offer1;
        Product2 = product2;
        this.offer2 = offer2;
        this.lati = lati;
        this.longi = longi;
        this.imageurl = imageurl;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getMobileno() {
        return Mobileno;
    }

    public void setMobileno(String mobileno) {
        Mobileno = mobileno;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getProduct1() {
        return Product1;
    }

    public void setProduct1(String product1) {
        Product1 = product1;
    }

    public String getOffer1() {
        return Offer1;
    }

    public void setOffer1(String offer1) {
        Offer1 = offer1;
    }

    public String getProduct2() {
        return Product2;
    }

    public void setProduct2(String product2) {
        Product2 = product2;
    }

    public String getOffer2() {
        return offer2;
    }

    public void setOffer2(String offer2) {
        this.offer2 = offer2;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
