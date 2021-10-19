package com.akbarmarunduri.swipeablevideo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akbarmarunduri.swipeablevideo.databinding.ItemContainerVideoBinding;

import java.util.List;

public class VideoAdaptor extends RecyclerView.Adapter<VideoAdaptor.VideoViewHoldeor> {

    private List<VideoItem> videoItems;

    public VideoAdaptor(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoViewHoldeor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHoldeor(
                ItemContainerVideoBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHoldeor holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }


    static class VideoViewHoldeor extends RecyclerView.ViewHolder {

        ItemContainerVideoBinding binding;

        public VideoViewHoldeor(ItemContainerVideoBinding itemContainerVideoBinding) {
            super(itemContainerVideoBinding.getRoot());
            this.binding = itemContainerVideoBinding;
        }

        void setVideoData(VideoItem videoItem) {
            binding.textVideotitle.setText(videoItem.videoTitle);
            binding.textVideoDescription.setText(videoItem.videoDescription);
            binding.videoView.setVideoPath(videoItem.videoUrl);
            binding.videoView.setOnPreparedListener(mp -> {
                binding.progressBar.setVisibility(View.GONE);
                mp.start();
                float videoRotasion = mp.getVideoHeight() / (float) mp.getVideoHeight();
                float screamRation = binding.videoView.getWidth() / (float) binding.videoView.getHeight();
                float scale = videoRotasion / screamRation;
                if (scale >= 1f) {
                    binding.videoView.setScaleX(scale);
                } else {
                    binding.videoView.setScaleY(1f / scale);
                }

                binding.videoView.setOnCompletionListener(mp1 -> mp1.start());
            });
        }
    }
}
