package com.example.videostreamingapplication.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("data.json")
    Call<Root>  getAllData();

}
