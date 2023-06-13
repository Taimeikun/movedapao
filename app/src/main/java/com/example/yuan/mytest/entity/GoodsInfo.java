package com.example.yuan.mytest.entity;

import com.example.yuan.mytest.R;

import java.util.ArrayList;

public class GoodsInfo {
    public int id;
    public String name;//名称
    public String description;//描述
    public Float pris;//价格
    public String picPath;//大图的保存路径
    public int pic;//大图的资源编号

    //声明一个手机商品名称的数组
    public static String[] nameArray = {"Mate30", "小米10", "iPhone15"," vivo 12", "荣耀30s"};
    //声明一个手机描述数组
    public static String[] descArray = {"红蓝炫彩 mate30", "小米10 米兰", "iPhone15 星空黑", "vivo12 无敌宝龙", "荣耀30s 极致高"};

    public static int[] picArray = {
            R.drawable.meta50, R.drawable.m10, R.drawable.iphone15,
            R.drawable.vivo50, R.drawable.ry30s
    };

//   public static int [] idArray = {1,2,3,4,5};

    public GoodsInfo(int pic, String name, String description) {
        this.name = name;
        this.description = description;
        this.pic = pic;
    }
    public GoodsInfo(int pic ,String name) {
        this.pic = pic;
        this.name = name;
    }

    public static ArrayList<GoodsInfo> getDefaultList() {

        ArrayList<GoodsInfo> goodsInfos = new ArrayList<>();
        for (int i = 0; i< picArray.length; i++) {
            goodsInfos.add(new GoodsInfo(picArray[i],nameArray[i],descArray[i]));
        }
        return goodsInfos;
    }
}
