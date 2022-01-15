package com.example.and3lesson22.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("description")
    String description;

    @SerializedName("director")
    String director;

    @SerializedName("image")
    private String image;

    public Film(String image) {
        this.image = image;
    }

    public int getRelease_Date() {
        return release_Date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRelease_Date(int release_Date) {
        this.release_Date = release_Date;
    }

    public int getRt_score() {
        return rt_score;
    }

    public void setRt_score(int rt_score) {
        this.rt_score = rt_score;
    }

    @SerializedName("release_date")
    int release_Date;

    @SerializedName("rt_score")
    int rt_score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
