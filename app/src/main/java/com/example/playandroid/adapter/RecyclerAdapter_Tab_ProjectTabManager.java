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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.playandroid.R;
import com.example.playandroid.model.bean.ProjectContentBean;
import com.example.playandroid.model.db.CollectTable;
import com.example.playandroid.model.dbdao.CollectTableDao;
import com.example.playandroid.view.webview.MyWebView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 11:55
 * Describe: ${as}
 */
public class RecyclerAdapter_Tab_ProjectTabManager extends RecyclerView.Adapter<RecyclerAdapter_Tab_ProjectTabManager.MyViewHolder> {
    private List<ProjectContentBean.DataBean.DatasBean> list = new ArrayList<>();
    private Context context;
    private CollectTableDao dao;

    public void refresh(List<ProjectContentBean.DataBean.DatasBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        dao = new CollectTableDao(context);
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_tab_projectfragment,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.title.setText(list.get(i).getTitle());
        myViewHolder.contents.setText(list.get(i).getDesc());
        myViewHolder.days.setText(list.get(i).getNiceDate());
        myViewHolder.author.setText(list.get(i).getAuthor());
        Glide.with(context).load(list.get(i).getEnvelopePic()).into(myViewHolder.imageView);

        myViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

        protected ImageView imageView;
        protected TextView title;
        protected TextView contents;
        protected TextView author;
        protected TextView days;
        protected CheckBox checkBox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview_item_tab_project);
            title = itemView.findViewById(R.id.title_item_tab_project);
            contents = itemView.findViewById(R.id.content_item_tab_project);
            author = itemView.findViewById(R.id.author_tab_projcet);
            days = itemView.findViewById(R.id.days_tab_project);
            checkBox = itemView.findViewById(R.id.checkbox_love_tab_project);
        }
    }
}
