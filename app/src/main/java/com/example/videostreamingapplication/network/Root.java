package com.example.videostreamingapplication.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root {

    @SerializedName("categories")
    private List<Categories> categories;

    public Root() {
    }

    public Root(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }
}
