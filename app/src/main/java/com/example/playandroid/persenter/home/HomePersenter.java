package com.example.playandroid.persenter.home;

import android.util.Log;

import com.example.playandroid.base.BasePresenter;
import com.example.playandroid.model.bean.AvaterBean;
import com.example.playandroid.model.bean.HomeRecyclerViewBean;
import com.example.playandroid.model.home.HomeCallBack;
import com.example.playandroid.model.home.HomeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 21:43
 * Describe: ${as}
 */
public class HomePersenter extends BasePresenter<HomeView> {

    public void getData(){

        new HomeModel().get(new HomeCallBack() {

            @Override
            public void success(String data) {

            }

            @Override
            public void failess(String message) {

                Log.i("GC","HomePersenter:"+message);
            }

            @Override
            public void successAvater(AvaterBean bean) {
                List<AvaterBean.DataBean> data = bean.getData();
                List<String> list = new ArrayList<>();
                List<String> list_title = new ArrayList<>();
                for(int i=0;i<data.size();i++){
                    list.add(data.get(i).getImagePath());
                    list_title.add(data.get(i).getTitle());
                }

                if(isAttach()){
                    getView().successAvater(list,list_title);
                }
            }

            @Override
            public void successHomeRecycerView(HomeRecyclerViewBean bean) {

                List<HomeRecyclerViewBean.DataBean.DatasBean> datas = bean.getData().getDatas();
                if(isAttach())
                getView().successHomeRecycerView(datas);
            }
        });
    }
}
