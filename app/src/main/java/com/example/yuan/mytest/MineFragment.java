package com.example.yuan.mytest;

import static android.app.Activity.RESULT_OK;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MineFragment extends Fragment implements View.OnClickListener {
    public static final int GGB = 123;
    private static final String ARG_TEXT = "param1";
    private int mInt;
    View rootView;
    private Context mContext;
    private ImageView imageView;
    private View view;
    private Button btn_frag_mine, btn_exit_log, btn_personal_result, btn_save,btn_return;
    private LinearLayout linearLayout;
    private TextView tv_display;
    private EditText et_nickname, et_sex, et_age;
    private TextView tv_age, tv_nickname, tv_sex;

    public static MineFragment newInstance(int s) {
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_TEXT, s);
        fragment.setArguments(bundle);
        return fragment;
    }
//    public static HomeFragment newInstance(int[] sArray){
//        HomeFragment fragment = new HomeFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(ARG_TEXT, sArray);
//    }


//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mInt = getArguments().getInt(ARG_TEXT);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mContext = getActivity();

        if (rootView == null) {
            //生成视图对象
            rootView = inflater.inflate(R.layout.fragment_mine, container, false);

            btn_exit_log = rootView.findViewById(R.id.btn_exit_log);//退出登录
            btn_personal_result = rootView.findViewById(R.id.btn_personal_result);//个人中心
            btn_frag_mine = rootView.findViewById(R.id.btn_ont_logged_in);//登录
            tv_display = rootView.findViewById(R.id.tv_display);//标题
            btn_save = rootView.findViewById(R.id.btn_save);//保存信息
            et_nickname = rootView.findViewById(R.id.et_nickname);//input nickname
            et_sex = rootView.findViewById(R.id.et_sex);//input性别
            et_age = rootView.findViewById(R.id.et_age);//input年龄
            tv_age = rootView.findViewById(R.id.tv_age);
            tv_nickname = rootView.findViewById(R.id.tv_nickname);
            tv_sex = rootView.findViewById(R.id.tv_sex);
            btn_return = rootView.findViewById(R.id.btn_return);

            btn_personal_result.setOnClickListener(this);
            btn_frag_mine.setOnClickListener(this);
            btn_save.setOnClickListener(this);
            btn_exit_log.setOnClickListener(this);
            btn_return.setOnClickListener(this);

//            initView();
        }
        view = rootView;
        return rootView;
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    private void initView() {
        int mImage = getArguments().getInt(ARG_TEXT);//取包裹

//        imageView = rootView.findViewById(R.id.iv_frag_);
//        imageView.setImageResource(mImage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ont_logged_in:
                Intent intent = new Intent();
                ComponentName c = new ComponentName(mContext, OnLoginActivity.class);
                intent.setComponent(c);
                startActivityForResult(intent, GGB);
                break;

            //点击个人信息 隐藏其他布局
            case R.id.btn_personal_result:
                btn_save.setVisibility(View.VISIBLE);
                btn_frag_mine.setVisibility(View.GONE);//隐藏登录按钮
                btn_exit_log.setVisibility(View.GONE);//隐藏退出登录
                btn_personal_result.setVisibility(View.GONE);//隐藏个人资料
                rootView.findViewById(R.id.layout_id).setVisibility(View.GONE);

                //显示可以修改昵称、性别、年龄布局
                tv_display.setVisibility(View.VISIBLE);//显示标题
                linearLayout = rootView.findViewById(R.id.layout_nick);
                linearLayout.setVisibility(View.VISIBLE);//显示信息
                break;

            //退出登录
            case R.id.btn_exit_log:
                btn_frag_mine.setVisibility(view.VISIBLE);//显示登录
                btn_exit_log.setVisibility(View.GONE);//隐藏退出登录
                //清除个人信息
                tv_nickname.setText("02123");
                tv_age.setText("未知");
                tv_sex.setText("未知");
                et_nickname.setText(null);
                et_age.setText(null);
                et_sex.setText(null);

                break;
            //点击保存信息
            case R.id.btn_save:
                Toast.makeText(mContext, "保存成功", Toast.LENGTH_SHORT).show();
                tv_nickname.setText(et_nickname.getText().toString());//保存名字
                tv_age.setText(et_age.getText().toString());//保存年龄
                tv_sex.setText(et_sex.getText().toString());//保存性别
                rt();//返回
                break;

            case R.id.btn_return:
                rt();
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //判断请求码和结果码是否匹配
        if (requestCode == GGB && resultCode == RESULT_OK) {
            //从 intent 中获取数据
            String inputNumber = data.getStringExtra("num");
            String inputPassWord = data.getStringExtra("pass");

            //进行相应的操作
            Toast.makeText(mContext, "你的密码是" + inputNumber + "/n你的密码是" + inputPassWord, Toast.LENGTH_SHORT).show();
            btn_frag_mine.setVisibility(View.GONE);//未登录不可见
            btn_personal_result.setVisibility(View.VISIBLE);//显示个人资料
            btn_exit_log.setVisibility(View.VISIBLE);//退出登录
            btn_exit_log.setOnClickListener(this);
            //修改信息按钮不可见
            btn_personal_result.setVisibility(View.VISIBLE);


        }
    }
    private void rt(){
        //保存之后然后返回,直接隐藏保存按钮、修改框
        tv_display.setVisibility(View.GONE);//隐藏标题
        linearLayout.setVisibility(View.GONE);//显示信息
        rootView.findViewById(R.id.layout_id).setVisibility(View.VISIBLE);//显示个人信息
        btn_exit_log.setVisibility(View.VISIBLE);//显示退出登录
        btn_save.setVisibility(View.GONE);//按钮
        btn_personal_result.setVisibility(View.VISIBLE);
    }
}
