package com.tinymonster.myrecyclerview;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFooterAutoLoadMoreListener{
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyRecyclerView myRecyclerView;
    private List<Integer> dataList=new ArrayList<>();
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        myRecyclerView=(MyRecyclerView)findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.addFooterAutoLoadMoreListener(this);
        myAdapter=new MyAdapter(dataList);
        myRecyclerView.setAdapter(myAdapter);
        loadMore();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myAdapter.notifyAllDatas(dataList,myRecyclerView);
                dataList.clear();
                dataList.addAll(Model.getData());
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void loadMore() {
        myAdapter.notifyAllDatas(dataList,myRecyclerView);
        List<Integer> list=Model.getData();
        dataList.addAll(list);
        swipeRefreshLayout.setRefreshing(false);
    }
}
