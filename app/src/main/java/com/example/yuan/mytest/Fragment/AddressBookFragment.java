package com.example.yuan.mytest.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.yuan.mytest.R;
import com.example.yuan.mytest.database.AddressRecyclerViewAdapter;
import com.example.yuan.mytest.entity.AddressEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddressBookFragment extends Fragment implements View.OnClickListener {

    private View mView;
    private Context mContext;
    private List<Map<String, Object>> list;
    private RecyclerView recyclerView;
    private List<AddressEntity> mAddressEntityList = new ArrayList<>();
    private SwipeRefreshLayout srl_swipe_refresh;
    private Boolean isFragmentVisibility = true;//初始化碎片可见


    public AddressBookFragment() {
    }

    public static AddressBookFragment newInstance() {
        AddressBookFragment fragment = new AddressBookFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        mView = inflater.inflate(R.layout.fragment_address_book, container, false);
        //初始化数据
        initView();
        //用于设置RecyclerView 的布局管理器和适配器。
        setupRecyclerView();
        //下拉刷新方法
        setupSwipeRefresh();
        return mView;
    }

    /**
     * 初始化数据
     */
    private void initView() {
        mAddressEntityList.clear();
        mAddressEntityList.add(new AddressEntity(R.drawable.icon_delete, "垃圾桶"));
        mAddressEntityList.add(new AddressEntity(R.drawable.icon_select, "√"));
        mAddressEntityList.add(new AddressEntity(R.drawable.icon_top, "顶针"));
        mAddressEntityList.add(new AddressEntity(R.drawable.icon_uncheck, "标记"));
        mAddressEntityList.add(new AddressEntity(R.drawable.alarm_clock, "闹钟"));
    }

    /**
     *  下拉刷新
     */
    private void setupSwipeRefresh() {
        srl_swipe_refresh = mView.findViewById(R.id.srl_swipe_refresh);
        //刷新监听
        srl_swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override//刷新时
            public void onRefresh() { //这个监听器中的 onRefresh() 响应方法是当用户下拉控件时被自动调用的
                //发布延迟 该方法有两个参数一个为执行方法 后一个为延迟毫秒，延迟结束执行run()
                srl_swipe_refresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startLayoutAnimation();//结束后开始动画
                        srl_swipe_refresh.setRefreshing(false);
                    }
                }, 1000);
            }
        });

    }

    /**
     * RecyclerView布局管理器和适配器
     */
    private void setupRecyclerView() {
        //回收布局RecyclerView
        recyclerView = mView.findViewById(R.id.rv_recycler);
        //创建布局管理器
        LinearLayoutManager linearLayout = new LinearLayoutManager(mContext);
        //设置布局管理器
        recyclerView.setLayoutManager(linearLayout);
        //创建适配器
        AddressRecyclerViewAdapter adapter = new AddressRecyclerViewAdapter(mAddressEntityList);
        //设置适配器
        recyclerView.setAdapter(adapter);
    }

    @Override//该方法在碎片可见、发生变化 时被调用
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isFragmentVisibility = !hidden;
        Log.d("123","0"+hidden);
    }

    /**
     * 开启动画
     */
    @SuppressLint("NotifyDataSetChanged")
    private void startLayoutAnimation() {
        if (recyclerView.getAdapter() != null && recyclerView.getLayoutManager() != null && isFragmentVisibility) {
            // 创建动画
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_left);
            // 获取布局动画控制器 `LayoutAnimationController` 对象来管理动画
            LayoutAnimationController controller = new LayoutAnimationController(animation);
            //设置延迟
            controller.setDelay(0.1f);
            //设置播放顺序正常
            controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
            //给recyclerView设置布局动画，传入LayoutAnimationController布局动画控制器
            recyclerView.setLayoutAnimation(controller);
            //告诉适配器数据变化
            recyclerView.getAdapter().notifyDataSetChanged();
            //启动动画
            recyclerView.scheduleLayoutAnimation();
        }
    }

    @Override//当一个 Fragment 变得可见并且处于活动状态时，系统会调用 onResume() 方法。
    public void onResume() {
        super.onResume();
        startLayoutAnimation();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mContext, "点击了条目", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.iv_icon_://如果是头像
//                intent.setClass(mContext,);
                Toast.makeText(mContext, "点击了头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_name_://如果是name
                Toast.makeText(mContext, "点击了标题", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}





