package com.other.finalproject.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.other.finalproject.MainApplication;
import com.other.finalproject.R;


/**
 * @author: hedianbo.
 * @date: 2019-12-16 11:04.
 * @desc:
 */

public class GlideHelper {

    private static MainApplication instance = MainApplication.getInstance();

    public static void loadImage(String url, ImageView view) {
        Glide.with(instance.getApplicationContext())
                .load(url)
                .placeholder(R.mipmap.defal)
                .error(R.mipmap.defal)
                .centerCrop()
                .into(view);
    }


    /**
     * Glide加载z资源图片
     */
    public static void loadLocalResource(int resourceId, ImageView view) {
        Glide.with(instance.getApplicationContext())
                .load(resourceId)
                .centerCrop()
                .dontAnimate()
                .priority(Priority.NORMAL)
                .into(view);
    }

    /**
     * Glide加载z资源图片
     */
    public static void loadLocalResource(String path, ImageView view) {
        Glide.with(instance.getApplicationContext())
                .load(path)
                .centerCrop()
                .dontAnimate()
                .priority(Priority.HIGH)
                .into(view);
    }

}
