package com.akbarmarunduri.swipeablevideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.akbarmarunduri.swipeablevideo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem musa = new VideoItem();
        musa.videoUrl = "https://youtu.be/Oqcevjp8Xao";
        musa.videoTitle = "ShakyBey Musa";
        musa.videoDescription = "Player Youtuber musa Black Desert online";
        videoItems.add(musa);

        VideoItem striker = new VideoItem();
        striker.videoUrl = "https://youtu.be/3VwHcC4_Z9M";
        striker.videoTitle = "FakeUni striker";
        striker.videoDescription = "Player Youtuber striker Black Desert online";
        videoItems.add(striker);

        binding.videoViewPager.setAdapter(new VideoAdaptor(videoItems));
    }
}