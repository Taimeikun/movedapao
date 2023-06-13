package com.example.yuan.mytest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.yuan.mytest.entity.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindFragment extends Fragment implements AdapterView.OnItemClickListener {
    private View mView;
    private Context mContext;
    private ListView lv_list_view;
    private List<Map<String, Object>> list;

    public FindFragment() {
    }

    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        mView = inflater.inflate(R.layout.fragment_find, container, false);
        //初始化数据和适配器、设置监听器
        initView();
        return mView;
    }

    private void initView() {
        list = new ArrayList<>();

        for (int i = 0; i < Fruit.iconArray.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", Fruit.nameArray[i]);
            item.put("icon", Fruit.iconArray[i]);
            list.add(item);
        }

        lv_list_view = mView.findViewById(R.id.lv_list_view);
        //适配器
        SimpleAdapter adapter = new SimpleAdapter(
                mContext, list, R.layout.item_find,
                new String[]{"name", "icon"},
                new int[]{R.id.tv_name, R.id.iv_icon}
        );
        lv_list_view.setAdapter(adapter);
        lv_list_view.setOnItemClickListener(this);
        //抢焦点
//        lv_list_view.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
    }
    //点击事件
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (mContext != null && list != null){
            Toast.makeText(mContext, "点击了第" + list.get(i).get("name"), Toast.LENGTH_SHORT).show();
        }
    }
}