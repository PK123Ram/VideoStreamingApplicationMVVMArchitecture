package com.example.videostreamingapplication.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.VolumeShaper;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import com.example.videostreamingapplication.R;
import com.example.videostreamingapplication.databinding.VideoPlayingItemBinding;
import com.example.videostreamingapplication.network.Data;

import static android.media.MediaPlayer.*;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class VideoPlayingActivity extends AppCompatActivity {

    private VideoPlayingItemBinding itemBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemBinding = DataBindingUtil.setContentView(this, R.layout.playing_video);
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        Data data = (Data) bundle.getSerializable("videoData");

        itemBinding.txtTitle.setText(data.getTitle());
        itemBinding.txtDesc.setText(data.getDescription());
        Uri uri = Uri.parse(data.getSources().get(0));
        itemBinding.videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        itemBinding.videoView.setMediaController(mediaController);

        itemBinding.videoView.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                itemBinding.videoView.start();
                itemBinding.progressBar.setVisibility(View.GONE);
            }
        });

        itemBinding.fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                itemBinding.fullScreen.setVisibility(View.GONE);
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                getWindow().addFlags(FLAG_FULLSCREEN);
                itemBinding.videoFrameLayout.setLayoutParams(new ConstraintLayout.LayoutParams(new WindowManager.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)));
                itemBinding.videoView.setLayoutParams(new FrameLayout.LayoutParams(new WindowManager.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)));

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        getSupportActionBar().show();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,250,getResources().getDisplayMetrics());
        itemBinding.videoFrameLayout.setLayoutParams(new ConstraintLayout.LayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,height)));
        itemBinding.videoView.setLayoutParams(new FrameLayout.LayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,height)));
        getWindow().clearFlags(FLAG_FULLSCREEN);

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            super.onBackPressed();
        }

    }
}
