package com.example.yuan.mytest.adpter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yuan.mytest.Fragment.DynamicFragment;
import com.example.yuan.mytest.entity.GoodsInfo;

import java.util.List;

public class MobilePagerAdapter extends FragmentPagerAdapter {

    private final List<GoodsInfo> mGoodsList;

    public MobilePagerAdapter(@NonNull FragmentManager fm, List<GoodsInfo> goodsInfoList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mGoodsList = goodsInfoList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        GoodsInfo info = mGoodsList.get(position);
        return DynamicFragment.newInstance(position, info.pic, info.description);
    }

    @Override
    public int getCount() {
        return mGoodsList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mGoodsList.get(position).name;
    }
}
