package com.example.yuan.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalInformationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_avatar;
    private TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        //初始化控件id
        initializationId();
        //初始化本页面数据
        initializationData();
        initView();

    }

    private void initializationId() {
        iv_avatar = findViewById(R.id.iv_avatar);
        tv_name = findViewById(R.id.tv_name);

    }

    private void initializationData() {
        Bundle bundle = getIntent().getExtras();
        //取出图片
        int tx = bundle.getInt("icon");
        iv_avatar.setImageResource(tx);
        String name = bundle.getString("name");
        tv_name.setText(name);
    }

    private void initView() {
        ImageView iv_finish_ = findViewById(R.id.iv_finish_);
        iv_finish_.setOnClickListener(this);
        ImageView iv_more = findViewById(R.id.iv_more);
        iv_more.setOnClickListener(this);
        Button go_chat = findViewById(R.id.go_chat);
        go_chat.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击返回
            case R.id.iv_finish_:
                finish();
                break;
            //点击更多
            case R.id.iv_more:
                Toast.makeText(this, "功能还未添加", Toast.LENGTH_SHORT).show();
                break;
            //点击发消息
            case R.id.go_chat:
                Intent intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;
        }
    }
}