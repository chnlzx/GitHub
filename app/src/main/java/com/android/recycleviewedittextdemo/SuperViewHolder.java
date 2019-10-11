package com.android.recycleviewedittextdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 作者：admin on 2017/4/5 17:24
 * 邮箱：androiden@163.com
 */


public class SuperViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;

    public SuperViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<>();
//        imageLoaderUtil = new ImageLoaderUtil();
    }


    public static SuperViewHolder createViewHolder(Context context, View itemView) {
        return new SuperViewHolder(context, itemView);
    }

    public static SuperViewHolder createViewHolder(Context context,
                                                   ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        return new SuperViewHolder(context, itemView);
    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }


    /****以下为辅助方法*****/

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public SuperViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public SuperViewHolder setChecked(int viewId, boolean isChecked) {
        CheckBox tv = getView(viewId);
        tv.setChecked(isChecked);
        return this;
    }



    public SuperViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public SuperViewHolder setImageUrl(int viewId, String url) {
        ImageView view= getView(viewId);

      /*  ImageLoader.Builder builder = new ImageLoader.Builder();
        ImageLoader img = builder.url(url)
                .imgView(view).strategy(ImageLoaderUtil.LOAD_STRATEGY_ONLY_WIFI).build();

        imageLoaderUtil.loadImage(mContext, img);*/

     /*   DisplayImageOptions options = new DisplayImageOptions.Builder()
                .displayer(new SimpleBitmapDisplayer())
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .showImageOnFail(R.mipmap.icon_timeline_pic)//加载失败显示图片
                .build();


        ImageLoader.getInstance().displayImage(url, view, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                view.setBackgroundResource(R.mipmap.icon_timeline_pic);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });*/





        return this;
    }

    public SuperViewHolder setImageUrlCommon(int viewId, String url) {
        ImageView view= getView(viewId);




        return this;
    }

    public SuperViewHolder setImageUrlNoCache(int viewId, String url) {
        ImageView view= getView(viewId);



        return this;
    }
    public SuperViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public SuperViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    /**
     * 关于事件的
     */
    public SuperViewHolder setOnClickListener(int viewId,
                                         View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }





}
