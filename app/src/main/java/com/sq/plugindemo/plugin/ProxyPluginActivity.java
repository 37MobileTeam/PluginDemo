package com.sq.plugindemo.plugin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.sq.plugindemo.MainActivity;
import com.sq.plugindemo.plugin.loader.ApkClassLoader;
import com.sq.standard.IActivityInterface;

public class ProxyPluginActivity extends Activity {

    static final String TAG = "37手游安卓团队";

    @Override
    public ApkClassLoader getClassLoader() {
        return MainActivity.mPlugin.mClassLoader;
    }

    @Override
    public Resources getResources() {
        return MainActivity.mPlugin.mResource;
    }

    private IActivityInterface pluginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("activity"))) {
            try {
                pluginActivity = getClassLoader().getInterface(IActivityInterface.class, intent.getStringExtra("activity"));
                pluginActivity.insertAppContext(this);
                pluginActivity.onCreate(new Bundle());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.e(TAG, "intent 中没带插件activity信息");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (pluginActivity != null) {
            pluginActivity.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (pluginActivity != null) {
            pluginActivity.onResume();
        }
    }

    @Override
    public void startActivity(Intent intent) {
        if (!TextUtils.isEmpty(intent.getStringExtra("activity"))) {
            intent.setClass(this, ProxyPluginActivity.class);
        }
        super.startActivity(intent);
    }
}
