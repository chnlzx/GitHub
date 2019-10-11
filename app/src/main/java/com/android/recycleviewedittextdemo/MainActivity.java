package com.android.recycleviewedittextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickLitener {

    private MyAdapter myAdapter;
    public LinearLayoutManager linearLayoutManager = null;
    private List<Order> list =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }

    private void initView() {
        RecyclerView rlv = findViewById(R.id.rlv);
        linearLayoutManager = new LinearLayoutManager(this);
        rlv.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(this);
        rlv.setAdapter(myAdapter);
        myAdapter.setmOnItemClickLitener(this);




    }

    private void initData() {

        list.add(new Order());
        myAdapter.setData(list);


    }


    @Override
    public void onItemOnPlusClick(View view, int position) {
        Toast.makeText(this,"增加了",Toast.LENGTH_SHORT).show();
        list.add(list.size(), new Order());
        myAdapter.addData(list.size());

    }

    @Override
    public void onItemOnReduceClick(View view, int position) {
        Toast.makeText(this,"减少了",Toast.LENGTH_SHORT).show();
        myAdapter.reduceData(position);
    }
}
