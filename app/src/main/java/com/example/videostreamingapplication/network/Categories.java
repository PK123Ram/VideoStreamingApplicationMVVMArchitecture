package com.example.videostreamingapplication.network;

import androidx.lifecycle.LiveData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categories {

    @SerializedName("name")
    private String name;

    @SerializedName("videos")
    private List<Data> dataList;

    public Categories(String name, List<Data> dataList) {
        this.name = name;
        this.dataList = dataList;
    }

    public Categories() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}
