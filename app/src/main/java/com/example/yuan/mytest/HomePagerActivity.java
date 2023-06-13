package com.example.yuan.mytest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.yuan.mytest.Fragment.AddressBookFragment;
import com.example.yuan.mytest.Fragment.WeiXinFragment;
import com.example.yuan.mytest.adpter.MyFragmentPagerAdapter;

import java.util.ArrayList;

public class HomePagerActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager2 viewPager;
    private LinearLayout llChat, llContacts, llFind, llProfile;
    private ImageView ivChat, ivContacts, ivFind, ivProfile, ivCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pager);

        initPager();
        initTabView();
    }

    private void initTabView() {

        llChat = findViewById(R.id.id_tab_weixin);//微信
        llChat.setOnClickListener(this);
        llContacts = findViewById(R.id.id_tab_contact);//通讯
        llContacts.setOnClickListener(this);
        llFind = findViewById(R.id.id_tab_find);//发现
        llFind.setOnClickListener(this);
        llProfile = findViewById(R.id.id_tab_profile);//我的
        llProfile.setOnClickListener(this);

        ivChat = findViewById(R.id.tab_iv_weixin);//微信图标
        ivContacts = findViewById(R.id.tab_iv_contact);//通讯图标
        ivFind = findViewById(R.id.tab_iv_find);//发现图标
        ivProfile = findViewById(R.id.tab_iv_profile);//我的图标
        ivChat.setSelected(true);//默认选择
        ivCurrent = ivChat;

    }

    private void initPager() {
        viewPager = findViewById(R.id.view_pager);
        //碎片数组
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(WeiXinFragment.newInstance());//add一个碎片
        fragments.add(AddressBookFragment.newInstance());
        fragments.add(FindFragment.newInstance());
        fragments.add(MineFragment.newInstance(R.drawable.vivo50));

        //创建适配器
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), fragments);
        viewPager.setAdapter(pagerAdapter);//设置适配器
        viewPager.setCurrentItem(0);//初始化页面

        //注册页面 变化回调。  也就是说在页面操作就会执行对应的方法  也就是操作捕捉。
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            //在页面滚动时、滑动时触发。   ‘通过控件选择会触发三次’
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                Toast.makeText(HomePagerActivity.this, "页面翻滚中0023", Toast.LENGTH_SHORT).show();
            }

            //重写父类方法，使用父类方法同时加入自己的逻辑
            //页面选择时
            public void onPageSelected(int position) {
//                Toast.makeText(HomePagerActivity.this, "选择了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
                super.onPageSelected(position);
                changeTab(position);

                if(position == 3){
//                    FrameLayout frameLayout = fragments.get(position).getView().findViewById(R.id.layout_index);
//                    Button button = new Button(HomePagerActivity.this);
//                    button.setText("按钮1");
//                    frameLayout.addView(button);
                }
            }
            //页面翻滚状态变化时  从静止到滑动时、滑动到静止触发
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
//                Toast.makeText(HomePagerActivity.this, "页面翻滚状态发生变化", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void changeTab(int position) {//页面下标
        ivCurrent.setSelected(false);//上一个页面未选中
        switch (position) {
            case R.id.id_tab_weixin://点击微信控件
                viewPager.setCurrentItem(0);//滑动到0
            case 0:
                ivChat.setSelected(true);//设置当前页面为选中
                ivCurrent = ivChat;//传进去用于更新未选中
                break;
            case R.id.id_tab_contact:
                viewPager.setCurrentItem(1);
            case 1:
                ivContacts.setSelected(true);
                ivCurrent = ivContacts;
                break;
            case R.id.id_tab_find:
                viewPager.setCurrentItem(2);
            case 2:
                ivFind.setSelected(true);
                ivCurrent = ivFind;
                break;
            case R.id.id_tab_profile:
                viewPager.setCurrentItem(3);
            case 3:
                ivProfile.setSelected(true);
                ivCurrent = ivProfile;
                break;
        }
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());//获取控件id
    }
}