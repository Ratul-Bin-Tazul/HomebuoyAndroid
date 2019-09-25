package com.ratulbintazul.homebuoyandroid.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.github.islamkhsh.CardSliderAdapter;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.ratulbintazul.homebuoyandroid.R;
import com.ratulbintazul.homebuoyandroid.model.Listing;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListingAdapter extends CardSliderAdapter<Listing> {

    ArrayList<Listing> listings;

    Context context;
    private SimpleExoPlayer player;
    private PlayerView playerView;

    public ListingAdapter(ArrayList<Listing> listings, Context context){
        super(listings);
        this.listings = listings;
        this.context = context;
    }

    private void initializePlayer(String url) {
        player = ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(context),
                new DefaultTrackSelector(), new DefaultLoadControl());

        playerView.setPlayer(player);

        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
        player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);

        player.setPlayWhenReady(true);
        player.setRepeatMode(Player.REPEAT_MODE_ALL);
        //player.seekTo(currentWindow, playbackPosition);

        Uri uri = Uri.parse(url);
        MediaSource mediaSource = buildMediaSource(uri);
        player.prepare(mediaSource, true, false);
    }

    private MediaSource buildMediaSource(Uri uri) {
        return new ExtractorMediaSource.Factory(
                new DefaultHttpDataSourceFactory("exoplayer-codelab")).
                createMediaSource(uri);
    }

    @Override
    public void bindView(int position, View itemContentView, Listing item) {
        //TODO bind item object with item layout view
        if(listings.get(position).getMEDIATYPE().equals("image")) {
            ImageView imageView = itemContentView.findViewById(R.id.imageContent);
            Log.e("url",item.getMEDIAURL());
            Picasso.get().load(item.getMEDIAURL()).placeholder(R.drawable.c1).into(imageView);
        }else {
            playerView = itemContentView.findViewById(R.id.video_view);

            initializePlayer(item.getMEDIAURL());

//            MediaController mediacontroller = new MediaController(context);
//            mediacontroller.setAnchorView(vv);
//            String uriPath = "https://github.com/MarcinMoskala/VideoPlayView/raw/master/videos/cat1.mp4"; //update package name
//            Uri uri = Uri.parse(item.getMEDIAURL());
//
//            vv.setMediaController(mediacontroller);
//            vv.setVideoURI(uri);
//            vv.requestFocus();
//            vv.start();
//
//            vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    vv.setMediaController(mediacontroller);
//                    vv.setVideoURI(uri);
//                    vv.requestFocus();
//                    vv.start();
//                }
//            });
        }


    }

    @Override
    public int getItemContentLayout(int position) {
        //TODO return the item layout of every position
        //This layout will be added as a child of CardView
        if(listings.get(position).getMEDIATYPE().equals("image"))
            return R.layout.image_content;
        else
            return R.layout.video_content;
    }
}