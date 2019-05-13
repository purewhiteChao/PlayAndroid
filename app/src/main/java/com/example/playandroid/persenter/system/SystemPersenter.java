package com.example.playandroid.persenter.system;

import com.example.playandroid.base.BasePresenter;
import com.example.playandroid.model.bean.SystemBean;
import com.example.playandroid.model.system.SystemCallBack;
import com.example.playandroid.model.system.SystemModel;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 14:16
 * Describe: ${as}
 */
public class SystemPersenter extends BasePresenter<SystemView> {

    public void getData(){
        new SystemModel().get(new SystemCallBack() {
            @Override
            public void success(SystemBean data) {

                List<SystemBean.DataBean> data1 = data.getData();
                if(isAttach()){
                    getView().success(data1);
                }
            }

            @Override
            public void failess(String message) {

                if(isAttach()){
                    getView().failess(message);
                }
            }
        });
    }
}
