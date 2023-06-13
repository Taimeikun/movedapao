package com.example.yuan.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Toast;

import com.example.yuan.mytest.adpter.ImagePagerAdapter;
import com.example.yuan.mytest.entity.GoodsInfo;

import java.util.ArrayList;

public class PagerTabActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ArrayList<GoodsInfo> mGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_tab);
        initPagerStrip();
        initViewPager();
    }

    //初始化翻页标签栏
    private void initViewPager() {
        PagerTabStrip pts_tab = findViewById(R.id.pts_tab);
        //设置标签栏文本大小
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        //设置颜色
        pts_tab.setTextColor(Color.BLACK);
    }

    //初始化翻页视图
    private void initPagerStrip() {
        ViewPager vp_content = findViewById(R.id.vp_content);
        //get数组
        mGoods = GoodsInfo.getDefaultList();
        //创建适配器
        ImagePagerAdapter adapter = new ImagePagerAdapter(this, mGoods);
        vp_content.setAdapter(adapter);
        vp_content.setCurrentItem(1);
        vp_content.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this, "翻到"+mGoods.get(position).name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}