package com.example.yuan.mytest.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.yuan.mytest.R;

public class StaticFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "fragment";

    //把碎片贴到页面上
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "Fragment,onAttach 把碎片贴到页面上");
    }

    //创建页面
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Fragment,onCreate 创建页面");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "Fragment , onCreateView");
        View view = inflater.inflate(R.layout.fragment_static, container, false);
        ImageView imageView = view.findViewById(R.id.iv_adv);
        TextView textView = view.findViewById(R.id.tv_adv);
        imageView.setOnClickListener(this);
        textView.setOnClickListener(this);
        return view;
    }

    //在活动页面创建后
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Fragment , onActivityCreated 在活动页面创建后");
        super.onActivityCreated(savedInstanceState);
    }

    //页面启动
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment , onStart 页面启动");
    }

    //页面回复
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Fragment , onResume 页面回复");
    }

    //页面暂停
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment , onPause 页面暂停");

    }

    //页面停止
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment , onStop 页面停止");
    }

    //销毁碎片视图
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "Fragment , onDestroyView 销毁碎片视图");
    }

    //页面销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment , onDestroy 页面销毁");
    }

    //把碎片从页面撕下来
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "Fragment , onDetach 把碎片从页面撕下来");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_adv:
                Toast.makeText(getContext(), "点击了图片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_adv:
                Toast.makeText(getContext(), "点击了文字", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}