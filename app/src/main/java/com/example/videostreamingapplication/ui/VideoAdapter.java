package com.example.videostreamingapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videostreamingapplication.R;
import com.example.videostreamingapplication.databinding.VideoListItem;
import com.example.videostreamingapplication.network.Data;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<Data> listOfData;

    public VideoAdapter(List<Data> listOfData) {
        this.listOfData = listOfData;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        VideoListItem listItem = DataBindingUtil.inflate(inflater, R.layout.video_item, parent, false);
        return new VideoViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoViewHolder holder, final int position) {
        Data data = listOfData.get(holder.getAdapterPosition());
        Picasso.get().load(listOfData.get(position).getThumb()).into(holder.listItem.img1);
        holder.bind(data);

        holder.listItem.videoCardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),VideoPlayingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("videoData",holder.listItem.getVideoItem());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfData.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        VideoListItem listItem;

        public VideoViewHolder(@NonNull VideoListItem itemView) {
            super(itemView.getRoot());
            this.listItem = itemView;
        }

        public void bind(Data data) {
            listItem.setVideoItem(data);
        }
    }

}
