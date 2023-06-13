package com.example.yuan.mytest.Util;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String getNowTime(){
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    public static String getDate(Calendar calendar){
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy--M-dd");
        return  sdf.format(date);

    }
    public static String getNowDateTime(String formatStr) {
        String format = formatStr;
        if (TextUtils.isEmpty(format)) {
            format = "yyyyMMddHHmmss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
}
