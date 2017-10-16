package com.example.yukai.mediaplayertest;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by yukai on 2017/10/14.
 */

public class TextureViewAdapter extends BaseAdapter{

    private Context mContext;
    private MediaPlayer mMediaPlayer;
    private String path = "/storage/emulated/0/test.mp4";
    private TextureView mTextureView;
    private Surface mSurface;

    public TextureViewAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null || true){
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item ,parent, false);
            mTextureView = (TextureView) view.findViewById(R.id.texture_view);
            Button button = (Button) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, BlankActivity.class);
                    mContext.startActivity(intent);
                }
            });
            if (position == 0){
                mTextureView.setVisibility(View.VISIBLE);
                mTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
                    @Override
                    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                        mSurface = new Surface(surface);
                        mMediaPlayer = new MediaPlayer();
                        try{
                            mMediaPlayer.setSurface(mSurface);
                            mMediaPlayer.reset();
                            mMediaPlayer.setDataSource(mContext, Uri.parse(path));
                            mMediaPlayer.prepare();
                            mMediaPlayer.start();
                            mMediaPlayer.setLooping(true);
                        }catch (Exception e){

                        }
                    }

                    @Override
                    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

                    }

                    @Override
                    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                        if (mMediaPlayer != null){
                            final MediaPlayer mediaPlayer = mMediaPlayer;
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    mediaPlayer.release();
                                }
                            }).start();
                        }
                        return true;
                    }

                    @Override
                    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

                    }
                });
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
