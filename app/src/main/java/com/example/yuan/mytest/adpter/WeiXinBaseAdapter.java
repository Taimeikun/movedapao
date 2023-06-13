package com.example.yuan.mytest.adpter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.mytest.PersonalInformationActivity;
import com.example.yuan.mytest.R;
import com.example.yuan.mytest.entity.WeiXinAnimeCharactersEntity;

import java.util.List;

public class WeiXinBaseAdapter extends BaseAdapter {

    private Context mContext;
    private List<WeiXinAnimeCharactersEntity> mAnimeList;

    public WeiXinBaseAdapter(Context mContext, List<WeiXinAnimeCharactersEntity> mArrayList) {
        this.mContext = mContext;
        this.mAnimeList = mArrayList;
    }

    @Override
    public int getCount() {
        return mAnimeList.size();
    }

    @Override
    public Object getItem(int i) {
        return mAnimeList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {//如果为null，表示该条目还未被加载过，初始化ViewGolder
            holder = new ViewHolder();// 创建一个对象传入进去 然后引用
            //该视图不依附于parent
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_weixin_list_view, parent, false);
            holder.id_iv_icon = convertView.findViewById(R.id.id_iv_icon);
            holder.id_tv_name = convertView.findViewById(R.id.id_tv_name);
            holder.id_tv_desc = convertView.findViewById(R.id.id_tv_desc);
            //自己弄的设置点击方法
            setClick(holder,position);
            convertView.setTag(holder);
        } else {
            //到这表示已经加载过条目了,可以直接get出来
            holder = (ViewHolder) convertView.getTag();
        }

        WeiXinAnimeCharactersEntity an = mAnimeList.get(position);//当前条目
        holder.id_iv_icon.setImageResource(an.getAnime());
        holder.id_tv_name.setText(an.getName());
        holder.id_tv_desc.setText(an.getDesc());
        return convertView;
    }

    private void setClick(ViewHolder holder, int position) {
        //点击了头像
        holder.id_iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //包裹
                Bundle bundle = new Bundle();
                bundle.putInt("icon",mAnimeList.get(position).getAnime());
                bundle.putString("name",mAnimeList.get(position).getName());


                //意图
                Intent intent = new Intent(mContext, PersonalInformationActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);//mContext是碎片的上下文，适配器不能直接用

            }
        });
    }

    public static final class ViewHolder {
         ImageView id_iv_icon;
         TextView id_tv_name;
         TextView id_tv_desc;

    }
}
