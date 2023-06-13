package com.example.yuan.mytest.database;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yuan.mytest.R;
import com.example.yuan.mytest.entity.AddressEntity;

import java.util.List;

public class AddressRecyclerViewAdapter extends RecyclerView.Adapter<AddressRecyclerViewAdapter.ViewHolder> {
    private static List<AddressEntity> M_ADDRESS_ENTITY_LIST;
    static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView iv_icon_;
        private final TextView tv_name_;
        public ViewHolder(@NonNull View itemView){
            super(itemView);//子布局

            iv_icon_ = itemView.findViewById(R.id.iv_icon_);
            tv_name_ = itemView.findViewById(R.id.tv_name_);
            iv_icon_.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();//获取当前点击在适配器的位置
                    Toast.makeText(itemView.getContext(), "点击了"+M_ADDRESS_ENTITY_LIST.get(position).getName()+"头像", Toast.LENGTH_SHORT).show();
                }
            });
            tv_name_.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();//获取当前点击在适配器的位置
                    Toast.makeText(itemView.getContext(), "点击了"+M_ADDRESS_ENTITY_LIST.get(position).getName()+"标题", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public AddressRecyclerViewAdapter(List<AddressEntity> addressEntityList) {
        super();
        Log.d("123","创建适配器2");
        M_ADDRESS_ENTITY_LIST = addressEntityList;
    }

    @NonNull//这个函数主要是用来加载子项布局（item_address_book）然后创建ViewHolder实例并把 子布局(item_address_book)传到构造函数中，最后返回ViewHolder实例。
    @Override//创建视图支架
    public AddressRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //获取视图
        Log.d("123","创建视图");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address_book, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override//绑定视图固定器
    public void onBindViewHolder(@NonNull AddressRecyclerViewAdapter.ViewHolder holder, int position){

        Log.d("123","现在是"+M_ADDRESS_ENTITY_LIST.get(position).getName());

        AddressEntity addressEntity = M_ADDRESS_ENTITY_LIST.get(position);
        holder.iv_icon_.setImageResource(addressEntity.getIcon());
        holder.tv_name_.setText(addressEntity.getName());
    }

    @Override
    public int getItemCount() {
        return M_ADDRESS_ENTITY_LIST.size();
    }
}
