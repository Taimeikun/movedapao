package com.example.yuan.mytest.entity;

import com.example.yuan.mytest.R;

import java.util.ArrayList;
import java.util.List;

public class WeiXinAnimeCharactersEntity {

    private int anime;
    private String name;
    private String desc;

    public WeiXinAnimeCharactersEntity(int anime, String name, String desc) {
        this.anime = anime;
        this.name = name;
        this.desc = desc;
    }
    public static int[] animeArray = {
            R.drawable.anime_1,R.drawable.anime_2,R.drawable.anime_3,
            R.drawable.anime_4,R.drawable.anime_5,R.drawable.anime_6,
            R.drawable.anime_7,R.drawable.anime_8,R.drawable.anime_9,
            R.drawable.anime_10
    };
    public static String[] nameArray = {
            "张三","李四","王麻子","张全蛋","吴广",
            "廖越西","李东","陈楠","欧阳蛋","慕容强"
    };

    public static String[] descArray = {
            "旅游爱好者","热衷健身跑步","音乐达人","忠诚职业生涯者","自由行爱好者",
            "美食家","意志坚定不屈服","真心热心帮助他人","活力四射","充满创意思维方式"
    };

    public static List<WeiXinAnimeCharactersEntity> getDefaultList(){
        List<WeiXinAnimeCharactersEntity> list = new ArrayList<>();
        for (int i = 0; i < animeArray.length; i++) {
            list.add(new WeiXinAnimeCharactersEntity(animeArray[i],nameArray[i], descArray[i]));
        }
        return list;
    }

    public int getAnime() {
        return anime;
    }

    public void setAnime(int anime) {
        this.anime = anime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static int[] getAnimeArray() {
        return animeArray;
    }

    public static void setAnimeArray(int[] animeArray) {
        WeiXinAnimeCharactersEntity.animeArray = animeArray;
    }

    public static String[] getNameArray() {
        return nameArray;
    }

    public static void setNameArray(String[] nameArray) {
        WeiXinAnimeCharactersEntity.nameArray = nameArray;
    }

    public static String[] getDescArray() {
        return descArray;
    }

    public static void setDescArray(String[] descArray) {
        WeiXinAnimeCharactersEntity.descArray = descArray;
    }
}
