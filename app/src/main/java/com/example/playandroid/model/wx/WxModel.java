package com.example.playandroid.model.wx;

import com.example.playandroid.base.BaseModel;
import com.example.playandroid.model.bean.ProjectContentBean;
import com.example.playandroid.model.bean.ProjectNameBean;
import com.example.playandroid.model.bean.SystemSubBean;
import com.example.playandroid.model.bean.WxContentBean;
import com.example.playandroid.model.bean.WxNameBean;
import com.example.playandroid.model.uri.Uris;
import com.example.playandroid.model.service.RetrofitService;
import com.example.playandroid.utils.RetrofitHelper;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 16:27
 * Describe: ${as}
 */
public class WxModel extends BaseModel<WxCallBack> {
    @Override
    protected void get(WxCallBack callback) {

    }
    @Override
    protected void post(WxCallBack callback) {

    }
    public Observable<WxNameBean> WxName(){
        Retrofit retrofit = RetrofitHelper.getInstance().initRetrofit(Uris.WANANDROID_URL);
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Observable<WxNameBean> wxName = retrofitService.getWxName();
        return wxName;
    }
    public Observable<WxContentBean> WxContentBean(int id,int page){
        Retrofit retrofit = RetrofitHelper.getInstance().initRetrofit(Uris.WANANDROID_URL);
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        String url = "wxarticle/list/"+id+"/"+page+"/json";
        Observable<WxContentBean> wxContent = retrofitService.getWxContent(url);
        return wxContent;
    }

    public Observable<ProjectNameBean> projectName(){
        Retrofit retrofit = RetrofitHelper.getInstance().initRetrofit(Uris.WANANDROID_URL);
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Observable<ProjectNameBean> projectName = retrofitService.getProjectName();
        return projectName;
    }

    public Observable<ProjectContentBean> projectContent(int id,int page){
        Retrofit retrofit = RetrofitHelper.getInstance().initRetrofit(Uris.WANANDROID_URL);
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        String url = "project/list/"+page+"/json?cid="+id;
        Observable<ProjectContentBean> projectContent = retrofitService.getProjectContent(url);
        return projectContent;
    }

    public Observable<ResponseBody> postLogin(String username,String pwd){
        Retrofit retrofit = RetrofitHelper.getInstance().initRetrofit(Uris.WANANDROID_URL);
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Observable<ResponseBody> responseBodyObservable = retrofitService.postLogin(username, pwd);
        return responseBodyObservable;
    }
    public Observable<ResponseBody> postRegister(String username,String pwd,String repwd){
        Retrofit retrofit = RetrofitHelper.getInstance().initRetrofit(Uris.WANANDROID_URL);
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Observable<ResponseBody> responseBodyObservable = retrofitService.postRegister(username, pwd, repwd);
        return responseBodyObservable;
    }
    public Observable<ResponseBody> getLogout(){
        Retrofit retrofit = RetrofitHelper.getInstance().initRetrofit(Uris.WANANDROID_URL);
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Observable<ResponseBody> logout = retrofitService.getLogout();
        return logout;
    }
    public Observable<SystemSubBean> getSystemSub(int id,int page){
        Retrofit retrofit = RetrofitHelper.getInstance().initRetrofit(Uris.WANANDROID_URL);
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        String url = "article/list/"+page+"/json?cid="+id;
        Observable<SystemSubBean> systemSub = retrofitService.getSystemSub(url);
        return systemSub;
    }

}
