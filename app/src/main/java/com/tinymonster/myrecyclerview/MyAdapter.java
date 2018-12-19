package com.tinymonster.myrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import static com.tinymonster.myrecyclerview.MyRecyclerView.VIEW_TYPE_FOOTER;
import static com.tinymonster.myrecyclerview.MyRecyclerView.VIEW_TYPE_NOMAL;

/**
 * Created by TinyMonster on 18/12/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Integer> list;//数据list
    private static final String TAG="MyAdapter";
    public MyAdapter(List<Integer> list) {
        this.list = list;
    }

    /**
     * 返回view类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        Log.e(TAG,"position:"+position);
        Log.e(TAG,"getItemViewType");
        if (position == getItemCount() - 1)//如果是最后一个item，则是底部布局
            return VIEW_TYPE_FOOTER;
        return VIEW_TYPE_NOMAL;  //正常item
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG,"onCreateViewHolder");
        if (viewType == VIEW_TYPE_FOOTER)
            return MyViewHolder.createViewHolder(parent, R.layout.item_root_footer);//返回底部布局
        return MyViewHolder.createViewHolder(parent, R.layout.item_normal); //返回正常item
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.e(TAG,"onBindViewHolder");
        int viewType = getItemViewType(position);
        if (viewType == VIEW_TYPE_NOMAL) {//正常item需要绑定数据
            TextView textView=holder.getView(R.id.item_TV);
            textView.setText(list.get(position).toString());
        }
    }

    /**
     * 返回item的数量
     * 因为在原有数据数量基础上加了一个底部布局，所以总的item数量应该+1
     * @return
     */
    @Override
    public int getItemCount() {
        int count = list.size();
        count++;
        return count;
    }

    /**
     * 刷新数据
     * @param mList
     */
    public void notifyAllDatas(List<Integer> mList,MyRecyclerView recyclerView) {
        this.list = mList;
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }
}
