package com.example.yuan.mytest;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.yuan.mytest.adpter.ImagePagerAdapter;
import com.example.yuan.mytest.entity.GoodsInfo;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager vp_content;
    private ArrayList<GoodsInfo> mGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        vp_content = findViewById(R.id.vp_content);
        //get数组
        mGoods = GoodsInfo.getDefaultList();
        //创建适配器
        ImagePagerAdapter adapter = new ImagePagerAdapter(this, mGoods);
        vp_content.setAdapter(adapter);
        vp_content.addOnPageChangeListener(this);
    }

    //翻页状态改变时触发。state取值说明：0表示禁止，1表示正在滑动，2表示滑动完毕
    //在翻页过程中，状态值依次变化为正在滑动 -> 滑动完毕 -> 静止
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //在翻页过程中触发。该方法的三个参数取值说明为 ：第一个参数表示当前页面的序号。
    //第二个参数表示页偏移的百分比，取值为0到1：第三个参数表示页面的偏移距离
    @Override
    public void onPageSelected(int position) {

    }

    @Override//在翻页结束触发。position 表示当前滑到了哪一页
    public void onPageScrollStateChanged(int position) {
        Toast.makeText(this, "当前页面" + mGoods.get(position).name, Toast.LENGTH_SHORT).show();
    }
}