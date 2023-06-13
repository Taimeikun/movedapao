package com.example.yuan.mytest.Fragment;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.yuan.mytest.HomePagerActivity;
import com.example.yuan.mytest.R;

public class LaunchFragment extends Fragment {

    private View view;
    private Context context;

    public static LaunchFragment newInstance(int count, int position, int image_id) {
        LaunchFragment fragment = new LaunchFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("count", count);
        args.putInt("image_id", image_id);
        fragment.setArguments(args);//把包裹塞给碎片
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getContext();
        Bundle arguments = getArguments();

        int position = arguments.getInt("position", 0);
        int image_id = arguments.getInt("image_id", 0);
        int count = arguments.getInt("count", 0);

        view = LayoutInflater.from(context).inflate(R.layout.fragment_launch, container, false);
//        View view = inflater.inflate(R.layout.fragment_launch,container,savedInstanceState);
        ImageView iv_launch_li = view.findViewById(R.id.iv_launch_li);
        RadioGroup rg_indicate_li = view.findViewById(R.id.rg_indicate_li);
        Button btn_start_li = view.findViewById(R.id.btn_start_li);
        iv_launch_li.setImageResource(image_id);

        for (int i = 0; i < count; i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            radioButton.setPadding(10, 10, 10, 10);
            rg_indicate_li.addView(radioButton);
        }
        //显示当前页单选为高亮
        ((RadioButton)rg_indicate_li.getChildAt(position)).setChecked(true);
        //    、、、如果是最后一个引导页就显示按钮  欢迎每一天
        if (position == count - 1) {
            btn_start_li.setVisibility(View.VISIBLE);
            btn_start_li.setOnClickListener(view1 -> {
                Toast.makeText(context, "欢迎美好的一天", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,HomePagerActivity.class);
                startActivity(intent);
            });
        }
        return view;
    }
}