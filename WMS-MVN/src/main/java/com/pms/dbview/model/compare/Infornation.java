package com.pms.dbview.model.compare;

/**
 * Created by 23626 on 2016/11/9.
 */
public class Infornation {

    public Integer num;

    public String str;

    public Infornation(){

    }
    public Infornation(Integer num, String str) {
        this.num = num;
        this.str = str;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
