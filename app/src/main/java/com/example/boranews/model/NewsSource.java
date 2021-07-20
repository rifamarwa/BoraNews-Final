package com.example.boranews.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsSource {

    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    public NewsSource(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
