package com.example.turistas;

public class Hotel {

    private int photography;
    private String name;
    private String price;
    private String context;


    public Hotel(int photography, String name, String price, String context) {
        this.photography = photography;
        this.name = name;
        this.price = price;
        this.context = context;
    }

    public int getPhotography() {
        return photography;
    }

    public void setPhotography(int photography) {
        this.photography = photography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContext(){return context;}

    public void setContext(String context){this.context = context;}

    //LastKey
}

