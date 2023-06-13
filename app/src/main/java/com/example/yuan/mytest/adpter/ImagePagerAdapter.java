package com.example.yuan.mytest.adpter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.yuan.mytest.entity.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

public class ImagePagerAdapter extends PagerAdapter {
    private final Context context;
    private final ArrayList<GoodsInfo> mGoodsList;
    private List<ImageView> mviewlist = new ArrayList<>();

    public ImagePagerAdapter(Context mContext , ArrayList<GoodsInfo> mGoodsList) {
        this.context = mContext;
        this.mGoodsList = mGoodsList;
        for (GoodsInfo info:mGoodsList) {
            ImageView view = new ImageView(mContext);
            view.setImageResource(info.pic);
            mviewlist.add(view);
        }
    }

    @Override
    public int getCount() {
        return mviewlist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override//实例化指定页面，并将其添加到容器中
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //添加一个view到contaienr中，而后返回一个跟这个view可以关联起来的对象，
        //这个对象是可以view自身，也能够是其余对象，
        //关键是isViewFromObject可以将view和这个object关联起来
        ImageView item = mviewlist.get(position);
        container.addView(item);
        return item ;
    }

    @Override//从容其中销毁指定位置的页面
    public void destroyItem(@NonNull ViewGroup container,int position, @NonNull Object object) {
        container.removeView(mviewlist.get(position));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mGoodsList.get(position).name;
    }
}
