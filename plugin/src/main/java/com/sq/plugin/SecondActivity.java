package com.sq.plugin;

import android.os.Bundle;
import android.view.View;

public class SecondActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin_second);
        findViewById(R.id.testView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomDialog(getContext()).show();
            }
        });
    }
}
