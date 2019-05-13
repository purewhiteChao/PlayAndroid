package com.example.playandroid.model.bean;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 14:31
 * Describe: ${as}
 */
public class CollectBean {
    private String tltle;
    private String author;
    private String subname;
    private String date;
    private String link;

    public CollectBean(String tltle, String author, String subname, String date, String link) {
        this.tltle = tltle;
        this.author = author;
        this.subname = subname;
        this.date = date;
        this.link = link;
    }

    public CollectBean() {
    }

    public String getTltle() {
        return tltle;
    }

    public void setTltle(String tltle) {
        this.tltle = tltle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
