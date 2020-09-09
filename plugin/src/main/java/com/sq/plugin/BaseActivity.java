package com.sq.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.sq.standard.IActivityInterface;

public class BaseActivity implements IActivityInterface {

    public BaseActivity() {

    }

    private Activity mAppActivity;

    @Override
    public void insertAppContext(Activity activity) {
        mAppActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //去除标题栏
        mAppActivity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏
        mAppActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void startActivity(Intent intent) {
        mAppActivity.startActivity(intent);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return mAppActivity.findViewById(id);
    }

    public void setContentView(int layoutResID) {
        mAppActivity.setContentView(layoutResID);
    }

    public Activity getContext() {
        return mAppActivity;
    }
}
