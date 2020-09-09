package com.sq.plugindemo.plugin;

import android.content.res.Resources;

import com.sq.plugindemo.plugin.loader.ApkClassLoader;

/**
 * @author zhuxiaoxin
 * 插件bean
 * 代表一个插件
 */
public class Plugin {

    public ApkClassLoader mClassLoader;

    public Resources mResource;

    public String mPath;

    public String getPluginPath() {
        return mPath;
    }

    public void setPluginPath(String path) {
        mPath = path;
    }

    public ClassLoader getClassLoader() {
        return mClassLoader;
    }

    public void setClassLoader(ApkClassLoader classLoader) {
        mClassLoader = classLoader;
    }

    public Resources getResource() {
        return mResource;
    }

    public void setResources(Resources resources) {
        mResource = resources;
    }
}
