package com.example.videostreamingapplication.repository;

import android.util.Log;
import android.widget.ProgressBar;

import androidx.lifecycle.MutableLiveData;

import com.example.videostreamingapplication.network.Api;
import com.example.videostreamingapplication.network.Data;
import com.example.videostreamingapplication.network.RetrofitClientInstance;
import com.example.videostreamingapplication.network.Root;
import com.example.videostreamingapplication.ui.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoRepository {

    private static final String TAG = "VideoRepository";
    private MutableLiveData<List<Data>> mutableList;

    public VideoRepository(){
        mutableList = new MutableLiveData<>();
    }

    public void getList() {

        Api api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);
        Call<Root> call = api.getAllData();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if(response.isSuccessful()){
                    mutableList.postValue(response.body().getCategories().get(0).getDataList());
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("VideoRepository","Response Failed"+t.getMessage());
            }
        });

    }

    public MutableLiveData<List<Data>> getMutableList() {
        return mutableList;
    }

}
