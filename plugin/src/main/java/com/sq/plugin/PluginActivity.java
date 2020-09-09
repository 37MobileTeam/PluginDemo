package com.sq.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class PluginActivity extends BaseActivity {


    private static final String TAG = "37手游安卓团队";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin);
        TextView textView = findViewById(R.id.testView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("activity", "com.sq.plugin.SecondActivity");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "Plugin onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "Plugin onResume");
    }
}
