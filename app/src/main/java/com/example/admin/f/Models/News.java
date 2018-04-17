package com.example.admin.f.Models;

/**
 * Created on 25.04.2017.
 */

public class News {
    Integer image;
    String title;
    String desc;

    public News(Integer image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public Integer getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
