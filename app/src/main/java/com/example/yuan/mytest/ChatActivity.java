package com.example.yuan.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        btnView();
    }

    private void btnView() {
        ImageView iv_finish_chat = findViewById(R.id.iv_finish_chat);
        iv_finish_chat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_finish_chat:
                finish();
                break;
        }
    }
}