package com.example.yuan.mytest.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.example.yuan.mytest.R;
public class DynamicFragment extends Fragment {

    public static DynamicFragment newInstance(int position, int image_id, String desc) {
        DynamicFragment fragment = new DynamicFragment();
        //把参数打包传入fragment
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putInt("image_id", image_id);
        bundle.putString("desc", desc);
        fragment.setArguments(bundle);
        return fragment;
    }

    //创建碎片视图
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //生成视图
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ImageView iv_pic = view.findViewById(R.id.iv_pic);
            TextView tv_desc = view.findViewById(R.id.tv_desc);
            iv_pic.setImageResource(arguments.getInt("image_id"));
//            iv_pic.setImageResource(arguments.getInt("position",0));//设置图片资源
            tv_desc.setText(arguments.getString("desc"));//设置文本
        }
        return view;

    }
}