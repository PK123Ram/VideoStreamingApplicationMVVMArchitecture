package com.example.videostreamingapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.videostreamingapplication.network.Data;
import com.example.videostreamingapplication.repository.VideoRepository;

import java.util.List;

public class VideoViewModel extends AndroidViewModel {
    private LiveData<List<Data>> dataList;
    private VideoRepository repository;

    public VideoViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        dataList = new MutableLiveData<>();
        repository = new VideoRepository();
    }


    public void getAllDataList() {
        repository.getList();
        dataList = repository.getMutableList();

    }

    public LiveData<List<Data>> getLiveDataList() {
        return dataList;
    }

}
