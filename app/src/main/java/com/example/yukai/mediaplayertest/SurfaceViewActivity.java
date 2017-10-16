package com.example.yukai.mediaplayertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SurfaceViewActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(new SurfaceViewAdapter(this));
    }
}
