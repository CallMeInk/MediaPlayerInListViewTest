package com.example.yukai.mediaplayertest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.MediaController;

/**
 * Created by yukai on 2017/10/14.
 */

public class VideoViewAdapter extends BaseAdapter{

    private Context mContext;
    private MyVideoView mVideoView;
    private String path = "/storage/emulated/0/test.mp4";

    public VideoViewAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (true || convertView == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item ,parent, false);
            mVideoView = (MyVideoView) view.findViewById(R.id.video_view);
            Button button = (Button) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, BlankActivity.class);
                    mContext.startActivity(intent);
                }
            });
            if (position == 0){
                mVideoView.setVisibility(View.VISIBLE);
                mVideoView.setMediaController(new MediaController(mContext));
                mVideoView.setVideoURI(Uri.parse(path));
                mVideoView.start();
            }
        }else{
            view = convertView;
        }
        return view;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

}

