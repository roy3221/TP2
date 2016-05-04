package com.fernandocejas.android10.sample.domain;

/**
 * Created by churong1 on 5/3/16.
 */
public class Product {
    private final int id;

    public Product(int id) {
        this.id = id;
    }

    private int image_width;
    private int image_height;
    private String image_url;

    public int getid() {
        return id;
    }
    public int getImage_width() { return image_width;}
    public int getImage_height() { return image_height;}
    public String getImage_url() { return image_url;}

    public void setImage_width(int image_width) { this.image_width = image_width;}
    public void setImage_height(int image_height) { this.image_height =  image_height;}
    public void setImage_url(String image_url) { this.image_url = image_url;}





}
