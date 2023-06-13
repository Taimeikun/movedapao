package com.example.yuan.mytest.entity;
import com.example.yuan.mytest.R;
public class Fruit {
    private String name;
    private int icon;

    public Fruit(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }
    public static String [] nameArray = {"橘子","草莓","石榴","苹果","车厘子"};

    public static int[] iconArray = {
            R.drawable.orange,R.drawable.strawberry,
            R.drawable.pomegranate,R.drawable.apple,R.drawable.cherry
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
