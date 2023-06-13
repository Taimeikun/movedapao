package com.example.yuan.mytest.entity;

public class BillInfo {
    public long rowid;
    public int xuhao;
    public String date;
    public int month;
    public int type;
    public double amount;
    public String desc;
    public String create_time;
    public String update_time;
    public String remark;

    public static final int BILL_TYPE_INCOME = 0;
    public static final int BILL_TYPE_COST = 1;

    public BillInfo() {
        rowid = 0L;
        xuhao = 0;
        date = "";
        month = 0;
        type = 0;
        amount = 0.0;
        desc = "";
        create_time = "";
        update_time = "";
        remark = "";
    }
}
