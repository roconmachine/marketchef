package com.roconmachine.app.marketchef.data.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by asus on 12/26/2016.
 */
public class SearchedItem{
    private Drawable thumb;
    private String title, price, description;
    private String detailPageLink;


    public Drawable getThumb() {
        return thumb;
    }

    public void setThumb(Drawable thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
