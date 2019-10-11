package com.android.recycleviewedittextdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyAdapter
 * @Description: java类作用描述
 * @Author: shawnleng
 * @CreateDate: 2019/10/11 14:58
 */
public class MyAdapter extends RecyclerView.Adapter<SuperViewHolder> {
    List<Order> list = new ArrayList<>();
    Context context;

    private OnItemClickLitener mOnItemClickLitener;

    public interface OnItemClickLitener {
        void onItemOnPlusClick(View view, int position);

        void onItemOnReduceClick(View view, int position);

    }

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setmOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public void setData(List<Order> list) {

        this.list = list;
        notifyDataSetChanged();
    }

    public void addData(int position) {
        notifyItemInserted(position);
    }

    public void reduceData(int position) {
        list.remove(position);
        //删除动画
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SuperViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        SuperViewHolder viewHolder = SuperViewHolder.createViewHolder(context, viewGroup, R.layout.item_add_rooms);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SuperViewHolder holder, final int position) {
        Order order = list.get(position);

        ImageView iv_reduce = holder.getView(R.id.iv_reduce);
        ImageView iv_add = holder.getView(R.id.iv_add);
        EditText et_room_name = holder.getView(R.id.et_room_name);


        if (et_room_name.getTag() != null) {
            et_room_name.removeTextChangedListener((TextWatcher) et_room_name.getTag());
        }

        AddTypeNameWatcher addTypeNameWatcher = new AddTypeNameWatcher(order);
        et_room_name.addTextChangedListener(addTypeNameWatcher);
        et_room_name.setTag(addTypeNameWatcher);
        et_room_name.setText(order.getName());



        if (position == 0) {
            iv_reduce.setVisibility(View.GONE);
        } else {
            iv_reduce.setVisibility(View.VISIBLE);
        }
        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickLitener.onItemOnPlusClick(v,position);
            }
        });
        iv_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickLitener.onItemOnReduceClick(v,position);
            }
        });






    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
