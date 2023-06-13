package com.example.yuan.mytest.Fragment;
/**
 * 引导页进入的ViewPager 第4页
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.yuan.mytest.ChatActivity;
import com.example.yuan.mytest.PersonalInformationActivity;
import com.example.yuan.mytest.R;
import com.example.yuan.mytest.adpter.WeiXinBaseAdapter;
import com.example.yuan.mytest.entity.WeiXinAnimeCharactersEntity;

import java.util.List;
public class WeiXinFragment extends Fragment {
    private View rootView;
    private Context mContext;
    private ListView id_lv_wei_xin;
    private SwipeRefreshLayout id_srl_wei_xin;

    private List<WeiXinAnimeCharactersEntity> listItem = WeiXinAnimeCharactersEntity.getDefaultList();

    public static WeiXinFragment newInstance() {
        return new WeiXinFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_weixin, container, false);
        }
        //ListVIew
        id_lv_wei_xin = rootView.findViewById(R.id.id_lv_wei_xin);
        //条目点击监听
        id_lv_wei_xin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(mContext, ChatActivity.class);
                startActivity(intent);
            }
        });
        //初始化视图
        initView();
        //设置一个下拉刷新
        setupRefresh();
        //适配器
        BaseAdapter adapter = new WeiXinBaseAdapter(mContext, listItem);
        //设置适配器
        id_lv_wei_xin.setAdapter(adapter);

        return rootView;
    }

    /**
     * 下拉刷新效果
     */
    private void setupRefresh() {
        id_srl_wei_xin = rootView.findViewById(R.id.id_srl_wei_xin);//下拉刷新
        id_srl_wei_xin.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                id_srl_wei_xin.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        id_srl_wei_xin.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    @Nullable
    @Override
    public View getView() {
        return rootView;
    }

    private void initView() {

    }
}
