package com.example.playandroid.adapter;

import android.content.ContentValues;
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
import com.example.playandroid.model.bean.SystemSubBean;
import com.example.playandroid.model.db.CollectTable;
import com.example.playandroid.model.dbdao.CollectTableDao;
import com.example.playandroid.view.webview.MyWebView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/12 0012
 * Time: 21:23
 * Describe: ${as}
 */
public class RecyclerAdapter_Tab_SysSubAvtivity extends RecyclerView.Adapter<RecyclerAdapter_Tab_SysSubAvtivity.MyVIewHolder> {
    private List<SystemSubBean.DataBean.DatasBean> list = new ArrayList<>();
    private Context context;
    private CollectTableDao dao;

    public void refresh(List<SystemSubBean.DataBean.DatasBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyVIewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        dao = new CollectTableDao(context);
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_homefragment,viewGroup,false);
        return new MyVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVIewHolder myVIewHolder, final int i) {

        myVIewHolder.title.setText(list.get(i).getTitle());
        myVIewHolder.top_title.setText(list.get(i).getAuthor());
        myVIewHolder.bottom_title.setText(list.get(i).getChapterName());
        myVIewHolder.days.setText(list.get(i).getNiceDate());

        myVIewHolder.love.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    list.get(i).setCollect(true);
                    ContentValues values = new ContentValues();
                    values.put(CollectTable.COL_TITLE,list.get(i).getTitle());
                    values.put(CollectTable.COL_AUTHOR,list.get(i).getAuthor());
                    values.put(CollectTable.COL_DATE,list.get(i).getNiceDate());
                    values.put(CollectTable.COL_SUBTITLE,list.get(i).getChapterName());
                    values.put(CollectTable.COL_LINK,list.get(i).getLink());
                    dao.insertDao(values);
                }else{
                    list.get(i).setCollect(false);
                    dao.deleteDao(list.get(i).getTitle());

                }
            }
        });
        myVIewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    class MyVIewHolder extends RecyclerView.ViewHolder{

        protected TextView title;
        protected TextView top_title;
        protected TextView bottom_title;
        protected TextView days;
        protected CheckBox love;
        public MyVIewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_item_homefragment);
            top_title= itemView.findViewById(R.id.toptitle_item_homefragment);
            bottom_title = itemView.findViewById(R.id.bottomtitle_item_homefragment);
            days = itemView.findViewById(R.id.days_item_homefragment);
            love = itemView.findViewById(R.id.checkbox_love);
        }
    }
}
