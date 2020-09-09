package com.sq.plugindemo.plugin.resources;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import java.io.InputStream;

/**
 * Resources资源先从插件获取，如果获取不到则从宿主获取
 */
public class MixResources extends ResourcesWrapper {

    private Resources mHostResources;

    public MixResources(Resources hostResources, Resources pluginResources) {
        super(pluginResources);
        mHostResources = hostResources;
    }

    @Override
    public CharSequence getText(int id) throws NotFoundException {
        try {
            return super.getText(id);
        } catch (NotFoundException e) {
            return mHostResources.getText(id);
        }
    }

    @Override
    public String getString(int id) throws NotFoundException {
        try {
            return super.getString(id);
        } catch (NotFoundException e) {
            return mHostResources.getString(id);
        }
    }

    @Override
    public String getString(int id, Object... formatArgs) throws NotFoundException {
        try {
            return super.getString(id,formatArgs);
        } catch (NotFoundException e) {
            return mHostResources.getString(id,formatArgs);
        }
    }

    @Override
    public float getDimension(int id) throws NotFoundException {
        try {
            return super.getDimension(id);
        } catch (NotFoundException e) {
            return mHostResources.getDimension(id);
        }
    }

    @Override
    public int getDimensionPixelOffset(int id) throws NotFoundException {
        try {
            return super.getDimensionPixelOffset(id);
        } catch (NotFoundException e) {
            return mHostResources.getDimensionPixelOffset(id);
        }
    }

    @Override
    public int getDimensionPixelSize(int id) throws NotFoundException {
        try {
            return super.getDimensionPixelSize(id);
        } catch (NotFoundException e) {
            return mHostResources.getDimensionPixelSize(id);
        }
    }

    @Override
    public Drawable getDrawable(int id) throws NotFoundException {
        try {
            return super.getDrawable(id);
        } catch (NotFoundException e) {
            return mHostResources.getDrawable(id);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Drawable getDrawable(int id, Theme theme) throws NotFoundException {
        try {
            return super.getDrawable(id, theme);
        } catch (NotFoundException e) {
            return mHostResources.getDrawable(id,theme);
        }
    }

    @Override
    public Drawable getDrawableForDensity(int id, int density) throws NotFoundException {
        try {
            return super.getDrawableForDensity(id, density);
        } catch (NotFoundException e) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                return mHostResources.getDrawableForDensity(id, density);
            } else {
                return null;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Drawable getDrawableForDensity(int id, int density, Theme theme) {
        try {
            return super.getDrawableForDensity(id, density, theme);
        } catch (Exception e) {
            return mHostResources.getDrawableForDensity(id,density,theme);
        }
    }

    @Override
    public int getColor(int id) throws NotFoundException {
        try {
            return super.getColor(id);
        } catch (NotFoundException e) {
            return mHostResources.getColor(id);
        }
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public int getColor(int id, Theme theme) throws NotFoundException {
        try {
            return super.getColor(id,theme);
        } catch (NotFoundException e) {
            return mHostResources.getColor(id,theme);
        }
    }

    @Override
    public ColorStateList getColorStateList(int id) throws NotFoundException {
        try {
            return super.getColorStateList(id);
        } catch (NotFoundException e) {
            return mHostResources.getColorStateList(id);
        }
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public ColorStateList getColorStateList(int id, Theme theme) throws NotFoundException {
        try {
            return super.getColorStateList(id,theme);
        } catch (NotFoundException e) {
            return mHostResources.getColorStateList(id,theme);
        }
    }

    @Override
    public boolean getBoolean(int id) throws NotFoundException {
        try {
            return super.getBoolean(id);
        } catch (NotFoundException e) {
            return mHostResources.getBoolean(id);
        }
    }

    @Override
    public XmlResourceParser getLayout(int id) throws NotFoundException {
        try {
            return super.getLayout(id);
        } catch (NotFoundException e) {
           return mHostResources.getLayout(id);
        }
    }

    @Override
    public String getResourceName(int resid) throws NotFoundException {
        try {
            return super.getResourceName(resid);
        } catch (NotFoundException e) {
            return mHostResources.getResourceName(resid);
        }
    }

    @Override
    public int getInteger(int id) throws NotFoundException {
        try {
            return super.getInteger(id);
        } catch (NotFoundException e) {
            return mHostResources.getInteger(id);
        }
    }

    @Override
    public CharSequence getText(int id, CharSequence def) {
        try {
            return super.getText(id,def);
        } catch (NotFoundException e) {
            return mHostResources.getText(id,def);
        }
    }

    @Override
    public InputStream openRawResource(int id) throws NotFoundException {
        try {
            return super.openRawResource(id);
        } catch (NotFoundException e) {
            return mHostResources.openRawResource(id);
        }

    }

    @Override
    public XmlResourceParser getXml(int id) throws NotFoundException {
        try {
            return super.getXml(id);
        } catch (NotFoundException e) {
            return mHostResources.getXml(id);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public Typeface getFont(int id) throws NotFoundException {
        try {
            return super.getFont(id);
        } catch (NotFoundException e) {
            return mHostResources.getFont(id);
        }
    }

    @Override
    public Movie getMovie(int id) throws NotFoundException {
        try {
            return super.getMovie(id);
        } catch (NotFoundException e) {
            return mHostResources.getMovie(id);
        }
    }

    @Override
    public XmlResourceParser getAnimation(int id) throws NotFoundException {
        try {
            return super.getAnimation(id);
        } catch (NotFoundException e) {
            return mHostResources.getAnimation(id);
        }
    }

    @Override
    public InputStream openRawResource(int id, TypedValue value) throws NotFoundException {
        try {
            return super.openRawResource(id,value);
        } catch (NotFoundException e) {
            return mHostResources.openRawResource(id,value);
        }
    }

    @Override
    public AssetFileDescriptor openRawResourceFd(int id) throws NotFoundException {
        try {
            return super.openRawResourceFd(id);
        } catch (NotFoundException e) {
            return mHostResources.openRawResourceFd(id);
        }
    }
}
