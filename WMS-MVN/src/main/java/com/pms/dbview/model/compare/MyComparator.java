package com.pms.dbview.model.compare;

import java.util.Comparator;

/**
 * Created by 23626 on 2016/11/9.
 */
public class MyComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Infornation cop1 = (Infornation) o1;
        Infornation cop2 = (Infornation) o2;
        int flag = cop1.getNum().compareTo(cop2.getNum());
        return flag;
    }
}
