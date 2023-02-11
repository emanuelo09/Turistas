package com.example.turistas;

public class Restaurant {

    private int image;
    private String title;
    private String sentence;
    private String type;

    public Restaurant(int image, String title, String sentence, String type) {
        this.image = image;
        this.title = title;
        this.sentence = sentence;
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

