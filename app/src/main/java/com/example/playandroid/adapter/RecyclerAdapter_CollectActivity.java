package com.example.playandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.CollectBean;
import com.example.playandroid.model.dbdao.CollectTableDao;
import com.example.playandroid.view.webview.MyWebView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 14:49
 * Describe: ${as}
 */
public class RecyclerAdapter_CollectActivity extends RecyclerView.Adapter<RecyclerAdapter_CollectActivity.MyViewHolder> {
    private List<CollectBean> list = new ArrayList<>();
    private Context context;
    private CollectTableDao dao;

    public void refresh(List<CollectBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        dao = new CollectTableDao(context);
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_homefragment,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.title.setText(list.get(i).getTltle());
        myViewHolder.top_title.setText(list.get(i).getAuthor());
        myViewHolder.bottom_title.setText(list.get(i).getSubname());
        myViewHolder.days.setText(list.get(i).getDate());
        myViewHolder.love.setChecked(true);

        myViewHolder.love.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    dao.deleteDao(list.get(i).getTltle());
                }
            }
        });
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyWebView.class);
                String link = list.get(i).getLink();
                intent.putExtra("url",link);
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
        protected TextView top_title;
        protected TextView bottom_title;
        protected TextView days;
        protected CheckBox love;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_item_homefragment);
            top_title= itemView.findViewById(R.id.toptitle_item_homefragment);
            bottom_title = itemView.findViewById(R.id.bottomtitle_item_homefragment);
            days = itemView.findViewById(R.id.days_item_homefragment);
            love = itemView.findViewById(R.id.checkbox_love);
        }
    }
}
