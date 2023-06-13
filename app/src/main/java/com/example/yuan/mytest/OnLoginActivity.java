package com.example.yuan.mytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yuan.mytest.Util.ToastUtil;
import com.example.yuan.mytest.entity.User;

public class OnLoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 123;
    private EditText et_account_number;
    private EditText et_password_number;
    private CheckBox ck_remember_password;


    private Button btn_logged_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_login);
        et_account_number = findViewById(R.id.et_account_number);//账号
        et_password_number = findViewById(R.id.et_password_number);//密码
        btn_logged_in = findViewById(R.id.btn_logged_in);   //登录按钮
        ck_remember_password = findViewById(R.id.ck_remember_password);//保存密码
        btn_logged_in.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //登录按钮
            case R.id.btn_logged_in:
                String inputAccount = et_account_number.getText().toString();//输入的账号
                String inputPassword = et_password_number.getText().toString();//输入的密码
                if (et_account_number.length() < 8) {
                    ToastUtil.show(this, "账号不规则");
                    return;
                }

                if (inputPassword.equals(User.password)) {//如果输入的密码匹配
                    //登录成功
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
//                    bundle.putString("id",inputAccount);
//                    bundle.putString("ps",inputPassword);
                    intent.putExtra("num",inputAccount);
                    intent.putExtra("pass",inputPassword);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
                if (!inputPassword.equals(User.password)) {//不匹配
                    ToastUtil.show(this, "你输入的密码不正确");//提示密码错误
                    return;
                }
                break;
        }
    }
}