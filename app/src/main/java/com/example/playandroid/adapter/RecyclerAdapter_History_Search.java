package com.example.playandroid.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playandroid.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/14 0014
 * Time: 13:17
 * Describe: ${as}
 */
public class RecyclerAdapter_History_Search extends RecyclerView.Adapter<RecyclerAdapter_History_Search.MyViewHolde> {
    public List<String> list = new ArrayList<>();
    private Context context;
    private OnHistoryCallBack callBack;

    public void setCallBack(OnHistoryCallBack callBack) {
        this.callBack = callBack;
    }

    public void refresh(List<String> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolde onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_history_searchdata,viewGroup,false);
        return new MyViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolde myViewHolde, final int i) {

        myViewHolde.textView.setText(list.get(i));
        myViewHolde.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onHistoryCallBack(list.get(i));
            }
        });
        myViewHolde.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onHistoryDeleteCallBack(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolde extends RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView;
        public MyViewHolde(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item_recycler_search);
            imageView = itemView.findViewById(R.id.delete_item_recycler_search);
        }
    }
    public interface OnHistoryCallBack{
        void onHistoryCallBack(String name);
        void onHistoryDeleteCallBack(int index);
    }
}
