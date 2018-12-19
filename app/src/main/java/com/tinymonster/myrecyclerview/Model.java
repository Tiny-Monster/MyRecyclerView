package com.tinymonster.myrecyclerview;

import android.os.Handler;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

/**
 * Created by TinyMonster on 17/12/2018.
 */

public class Model {
    public static List<Integer> getData(){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add(i);
        }
        return list;
    }
}
