package com.sq.plugindemo.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import com.sq.plugindemo.plugin.loader.ApkClassLoader;
import com.sq.plugindemo.plugin.resources.MixResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * 占位式插件
 */
public class PluginManager {

    private static PluginManager sInstance;

    private Context mContext;

    private String mPluginPath;

    private PluginManager(Context context) {
        mContext = context;
    }

    public static PluginManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PluginManager(context);
        }
        return sInstance;
    }

    public Plugin loadPlugin(String name) {
        mPluginPath = copyAssetPlugin(name);
        Plugin plugin = new Plugin();
        plugin.setPluginPath(mPluginPath);
        File file = mContext.getDir("plugin-opti", Context.MODE_PRIVATE);
        String[] interfaces = new String[]{"com.sq.standard"};
        //获取ClassLoader
        ApkClassLoader pluginClassLoader = new ApkClassLoader(mPluginPath, file.getAbsolutePath(), null, mContext.getClassLoader(), interfaces);
        plugin.setClassLoader(pluginClassLoader);
        try {
            //该方法获取Resources会依赖育addAssetPath方法，而该方法已废弃
//            AssetManager assetManager = AssetManager.class.newInstance();
//            Method addAssetPathMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
//            addAssetPathMethod.invoke(assetManager, mPluginPath);
//            Resources resources = new Resources(assetManager, mContext.getResources().getDisplayMetrics(), mContext.getResources().getConfiguration());
            Resources resources = new MixResources(mContext.getResources(), buildPluginResources());
            plugin.setResources(resources);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plugin;
    }

    private Resources buildPluginResources(){
        try {
            PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES|PackageManager.GET_META_DATA
                    |PackageManager.GET_SERVICES
                    |PackageManager.GET_PROVIDERS
                    |PackageManager.GET_SIGNATURES);
            packageInfo.applicationInfo.publicSourceDir = mPluginPath;
            packageInfo.applicationInfo.sourceDir = mPluginPath;
            return mContext.getPackageManager().getResourcesForApplication(packageInfo.applicationInfo);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String copyAssetPlugin(String assetName) {
        InputStream inputStream = null;
        try {
            inputStream = mContext.getAssets().open(assetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File pluginDirFile = mContext.getDir("plugin", Context.MODE_PRIVATE);
        if (!pluginDirFile.exists()) {
            pluginDirFile.mkdirs();
        }
        File resultFile = new File(pluginDirFile, assetName);
        writeInputStream(resultFile.getAbsolutePath(), inputStream);
        return resultFile.getAbsolutePath();
    }

    private void writeInputStream(String storagePath, InputStream inputStream) {
        File file = new File(storagePath);
        try {
            if (!file.exists()) {
                // 1.建立通道对象
                FileOutputStream fos = new FileOutputStream(file);
                // 2.定义存储空间
                byte[] buffer = new byte[inputStream.available()];
                // 3.开始读文件
                int lenght = 0;
                while ((lenght = inputStream.read(buffer)) != -1) {// 循环从输入流读取buffer字节
                    // 将Buffer中的数据写到outputStream对象中
                    fos.write(buffer, 0, lenght);
                }
                fos.flush();// 刷新缓冲区
                // 4.关闭流
                fos.close();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}