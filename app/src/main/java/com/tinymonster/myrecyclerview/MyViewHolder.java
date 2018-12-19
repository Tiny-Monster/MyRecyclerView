package com.tinymonster.myrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TinyMonster on 17/12/2018.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{
    private SparseArray<View> mHolderView;//缓存子控件View
    private View ParentView;    //最外层view

    public MyViewHolder(View itemView) {
        super(itemView);
        this.ParentView=itemView;

        if(mHolderView==null){
            mHolderView=new SparseArray<>();
        }
    }

    /**
     * 根据layoutID创建ViewHolder
     * @param parent
     * @param layoutId
     * @return
     */
    public static MyViewHolder createViewHolder(ViewGroup parent,int layoutId){
        View view= LayoutInflater.from(parent.getContext()).inflate(layoutId,parent,false);
        return new MyViewHolder(view);
    }

    /**
     * 根据View创建viewHolder
     * @param view
     * @return
     */
    public static MyViewHolder createViewHolder(View view){
        return new MyViewHolder(view);
    }

    /**
     * 获取View
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int id){
        View view=mHolderView.get(id);
        if(view==null){
            view=ParentView.findViewById(id);
            mHolderView.put(id,view);
        }
        return (T) view;
    }
}
