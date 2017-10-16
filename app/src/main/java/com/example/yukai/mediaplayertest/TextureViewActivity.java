package com.example.yukai.mediaplayertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

/**
 * Created by yukai on 2017/10/14.
 */

public class TextureViewActivity extends Activity{

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(new TextureViewAdapter(this));
    }
}
