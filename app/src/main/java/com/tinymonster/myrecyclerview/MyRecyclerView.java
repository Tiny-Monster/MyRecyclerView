package com.tinymonster.myrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * Created by TinyMonster on 17/12/2018.
 */

public class MyRecyclerView extends RecyclerView{
    private static final String TAG="MyRecyclerView";
    private OnFooterAutoLoadMoreListener listener;//监听底部
    public static final int VIEW_TYPE_NOMAL = 0;//item的类型-正常的item
    public static final int VIEW_TYPE_FOOTER = 200;//item的类型-底部

    public MyRecyclerView(Context context) {
        this(context,null);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addOnScrollListener(mOnScrollListener);//添加底部加载接口
    }

    /**
     * 滑动监听
     * 滑动到最后一个item的底部时加载更多信息
     */
    private OnScrollListener mOnScrollListener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if(!canScrollVertically(1)){
                if (listener != null) {
                        listener.loadMore();
                }
            }
        }
    };
    /**
     * 添加底部加载接口
     * @param listener
     */
    public void addFooterAutoLoadMoreListener(OnFooterAutoLoadMoreListener listener){
        this.listener=listener;
    }
}
