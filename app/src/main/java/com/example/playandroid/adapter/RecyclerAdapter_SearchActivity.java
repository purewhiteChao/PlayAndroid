package com.example.playandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.SerachHotMsgBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 22:56
 * Describe: ${as}
 */
public class RecyclerAdapter_SearchActivity extends RecyclerView.Adapter<RecyclerAdapter_SearchActivity.MyViewHolder> {
    public List<SerachHotMsgBean.DataBean> list = new ArrayList<>();
    private Context context;
    private OnCallBack onCallBack;

    public void setOnCallBack(OnCallBack onCallBack) {
        this.onCallBack = onCallBack;
    }

    public void refresh(List<SerachHotMsgBean.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_search,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.textView.setText(list.get(i).getName());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.oncallback(list.get(i).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text_search);

        }
    }
    public interface OnCallBack{
        void oncallback(String name);
    }
}
