package com.example.playandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.SystemBean;
import com.example.playandroid.persenter.system.SystemView;
import com.example.playandroid.view.activity.systemsub.SystemSubActivity;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 14:38
 * Describe: ${as}
 */
public class RecyclerAdapter_SystemFragment extends RecyclerView.Adapter<RecyclerAdapter_SystemFragment.MyViewHolder> {
    private List<SystemBean.DataBean> list = new ArrayList<>();
    private Context context;
    public RecyclerAdapter_item_SystemFragment adapter;

    public void refresh(List<SystemBean.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_systemfragment,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.title.setText(list.get(i).getName());
        adapter.refresh(list.get(i).getChildren());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SystemSubActivity.class);
                Bundle bundle = new Bundle();
                SystemBean.DataBean dataBean = list.get(i);
                bundle.putSerializable("list", (Serializable) dataBean);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        protected TextView title;
        protected RecyclerView recyclerView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_item_systemfragment);
            recyclerView = itemView.findViewById(R.id.recycler_item_systemfragment);
            FlexboxLayoutManager manager = new FlexboxLayoutManager(context);
            manager.setFlexDirection(FlexDirection.ROW);
            recyclerView.setLayoutManager(manager);
            adapter = new RecyclerAdapter_item_SystemFragment();
            recyclerView.setAdapter(adapter);
        }
    }
}
