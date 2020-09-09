package com.sq.standard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public interface IActivityInterface {

    //插入上下文环境
    void insertAppContext(Activity activity);

    void onCreate(Bundle savedInstanceState);

    public <T extends View> T findViewById(int id);

    void onResume();

    void onStart();

    void onStop();

    void onDestroy();

    void startActivity(Intent intent);

}
