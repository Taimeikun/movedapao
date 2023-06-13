package com.example.yuan.mytest;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import com.example.yuan.mytest.adpter.MobilePagerAdapter;
import com.example.yuan.mytest.entity.GoodsInfo;

import java.util.ArrayList;

public class FragmentDynamicActivity extends AppCompatActivity {
    private ArrayList<GoodsInfo> mGoodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);
        initPagerStrip();
        initViewPager();
    }

    private void initViewPager() {
        PagerTabStrip ptf = findViewById(R.id.pts_tab);
        //设置标签栏文本大小
        ptf.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        //设置颜色
        ptf.setTextColor(Color.BLACK);
    }

    //初始化翻页视图
    private void initPagerStrip() {
        ViewPager vp_content = findViewById(R.id.vp_content);
        //get数组
        mGoodsList = GoodsInfo.getDefaultList();
        //创建适配器
        MobilePagerAdapter mobilePagerAdapter = new MobilePagerAdapter(getSupportFragmentManager(), mGoodsList);
        vp_content.setAdapter(mobilePagerAdapter);


    }
}