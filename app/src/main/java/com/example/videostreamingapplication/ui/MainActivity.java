package com.example.videostreamingapplication.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.videostreamingapplication.R;
import com.example.videostreamingapplication.databinding.MainActivityBinding;
import com.example.videostreamingapplication.network.Data;
import com.example.videostreamingapplication.viewmodel.VideoViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    MainActivityBinding activityBinding;
    private VideoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(VideoViewModel.class);
        viewModel.init();
        progressBar = new ProgressBar(this);
        progressBar.setVisibility(View.VISIBLE);
        viewModel.getAllDataList();
        setUpObservers();
    }


    public void setUpObservers() {
        viewModel.getLiveDataList().observe(this, new Observer<List<Data>>() {
            @Override
            public void onChanged(List<Data> data) {
                activityBinding.recyclerView.setAdapter(new VideoAdapter(data));
                progressBar.setVisibility(View.GONE);
            }
        });

    }


}