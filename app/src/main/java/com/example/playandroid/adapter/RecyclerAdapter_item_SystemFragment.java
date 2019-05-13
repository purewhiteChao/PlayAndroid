package com.example.playandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.SystemBean;
import com.example.playandroid.view.activity.systemsub.SystemSubActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 15:41
 * Describe: ${as}
 */
public class RecyclerAdapter_item_SystemFragment extends RecyclerView.Adapter<RecyclerAdapter_item_SystemFragment.MyViewHolder> {
    private List<SystemBean.DataBean.ChildrenBean> list = new ArrayList<>();
    private Context context;

    public void refresh(List<SystemBean.DataBean.ChildrenBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_item_systemfragment,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.text.setText(list.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text_item_systemfragment);
        }
    }
}
