package com.sq.plugindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.sq.plugindemo.plugin.Plugin;
import com.sq.plugindemo.plugin.PluginManager;
import com.sq.plugindemo.plugin.ProxyPluginActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    public static Plugin mPlugin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        findViewById(R.id.load_plugin).setOnClickListener(this);
        findViewById(R.id.open_activity).setOnClickListener(this);
    }

    private void startPluActivity() {
        if (mPlugin == null) {
            Toast.makeText(getApplicationContext(), "请先加载插件", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, ProxyPluginActivity.class);
        intent.putExtra("activity", "com.sq.plugin.PluginActivity");
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_activity:
                startPluActivity();
                break;
            case R.id.load_plugin:
                mPlugin = PluginManager.getInstance(MainActivity.this).loadPlugin("plugin8.apk");
                Toast.makeText(getApplicationContext(), "加载插件成功", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
