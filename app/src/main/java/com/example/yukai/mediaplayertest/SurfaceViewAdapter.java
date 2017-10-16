package com.example.yukai.mediaplayertest;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.io.IOException;

/**
 * Created by yukai on 2017/10/14.
 */

public class SurfaceViewAdapter extends BaseAdapter{

    private Context mContext;
    private MediaPlayer mMediaPlayer;
    private String path = "/storage/emulated/0/test.mp4";

    public SurfaceViewAdapter(Context context){
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
            SurfaceView surfaceView = (SurfaceView) view.findViewById(R.id.surface_view);
            Button button = (Button) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, BlankActivity.class);
                    mContext.startActivity(intent);
                }
            });
            if (position == 0){
                surfaceView.setVisibility(View.VISIBLE);
                if (mMediaPlayer != null){
                    mMediaPlayer.release();
                    mMediaPlayer = null;
                }
                mMediaPlayer = new MediaPlayer();
                try{
                    mMediaPlayer.setDataSource(mContext, Uri.parse(path));
                    SurfaceHolder holder = surfaceView.getHolder();
                    holder.addCallback(new MyCallBack());
                    mMediaPlayer.prepareAsync();
                    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mMediaPlayer.start();
                            mMediaPlayer.setLooping(true);
                        }
                    });
                }catch (IOException e){
                    //
                }
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

    private class MyCallBack implements SurfaceHolder.Callback{
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            if (mMediaPlayer != null){
                mMediaPlayer.setDisplay(holder);
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            if (mMediaPlayer != null){
                mMediaPlayer.release();
                mMediaPlayer = null;
            }
        }
    }

}
