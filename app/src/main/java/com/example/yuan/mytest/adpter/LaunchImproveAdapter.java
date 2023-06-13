package com.example.yuan.mytest.adpter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yuan.mytest.Fragment.LaunchFragment;

public class LaunchImproveAdapter extends FragmentPagerAdapter {
    private final int[] mImageArray;

    public LaunchImproveAdapter(@NonNull FragmentManager fm, int[] launchImageArray){
        super(fm);
        this.mImageArray = launchImageArray;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return LaunchFragment.newInstance(mImageArray.length,position,mImageArray[position]);
    }

    @Override
    public int getCount() {
        return mImageArray.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
