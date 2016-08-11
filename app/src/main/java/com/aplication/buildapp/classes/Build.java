package com.aplication.buildapp.classes;

/**
 * Created by yoshi on 8/7/16.
 */
public class Build {

    private String buildName;
    private int imgBuild;
    private String author;
    private String date;
    private int imgSeason;

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public int getImgBuild() {
        return imgBuild;
    }

    public void setImgBuild(int imgBuild) {
        this.imgBuild = imgBuild;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImgSeason() {
        return imgSeason;
    }

    public void setImgSeason(int imgSeason) {
        this.imgSeason = imgSeason;
    }

    @Override
    public String toString() {
        return buildName;
    }
}


