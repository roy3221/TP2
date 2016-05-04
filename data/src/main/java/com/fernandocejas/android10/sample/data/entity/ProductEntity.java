package com.fernandocejas.android10.sample.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by churong1 on 5/3/16.
 */
public class ProductEntity {

    @SerializedName("id")
    private int id;

    @SerializedName("image_width")
    private int image_width;

    @SerializedName("image_height")
    private int image_height;

    @SerializedName("image_url")
    private String image_url;

    public ProductEntity() {
        //empty
    }

    public int getId() {

        return id;
    }

    public String getImage_url() {

        return image_url;
    }

    public int getImage_width() {
        return image_width;
    }

    public int getImage_height() {
        return image_height;
    }


}
