package com.example.playandroid.view.fragment.person;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseFragment;
import com.example.playandroid.base.BaseMVPFragment;
import com.example.playandroid.model.uri.Uris;
import com.example.playandroid.persenter.login.LoginPresenter;
import com.example.playandroid.persenter.login.LoginView;
import com.example.playandroid.utils.RxBus;
import com.example.playandroid.view.activity.collect.CollectActivity;
import com.example.playandroid.view.activity.login.LoginActivity;
import com.example.playandroid.view.activity.setting.SettingActivity;
import com.example.playandroid.view.customview.CircleImageView;

import butterknife.BindView;
import rx.Observer;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 13:28
 * Describe: ${as}
 */
public class PersonFragment extends BaseMVPFragment<LoginPresenter, LoginView,String> implements LoginView {
    @BindView(R.id.imagevie_personfragment)
    CircleImageView imageviePersonfragment;
    @BindView(R.id.username_personfragment)
    TextView usernamePersonfragment;
    @BindView(R.id.btn_login_perfragment)
    Button btnLoginPerfragment;
    @BindView(R.id.constrain_personfragment)
    ConstraintLayout constrainPersonfragment;
    @BindView(R.id.navigation_personfragment)
    NavigationView navigationPersonfragment;
    @BindView(R.id.btn_logout_personfragment)
    Button btnLogoutPersonfragment;
    private String username;

    public PersonFragment(){

    }
//    @SuppressLint("ValidFragment")
//    public PersonFragment(String username){
//        this.username = username;
//        Uris.user = username;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(!Uris.isLogin){
            usernamePersonfragment.setVisibility(View.GONE);
            btnLoginPerfragment.setVisibility(View.VISIBLE);
            btnLogoutPersonfragment.setVisibility(View.GONE);
        }else{
            usernamePersonfragment.setVisibility(View.VISIBLE);
            btnLogoutPersonfragment.setVisibility(View.VISIBLE);
            btnLoginPerfragment.setVisibility(View.GONE);
            usernamePersonfragment.setText(Uris.user);
        }
        initListener();
    }

    @Override
    protected LoginPresenter getPersenter() {
        return new LoginPresenter();
    }

    private void initListener() {
        receiveBus();
        navigationPersonfragment.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getTitle().equals("设置")){

                    Intent intent = new Intent(getActivity(), SettingActivity.class);
                    startActivity(intent);
                }else if(menuItem.getTitle().equals("我的收藏")){

                    if(Uris.isLogin){
                        Intent intent = new Intent(getActivity(), CollectActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });
        btnLoginPerfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        btnLogoutPersonfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persenter.getLogout();
            }
        });
    }

    @Override
    public int getContextView() {
        return R.layout.fragment_person_layout;
    }


    @Override
    public void successLogin(String data) {

    }

    @Override
    public void successRegister(String data) {

    }

    @Override
    public void successLogout(String data) {

        Log.e("guochao","successLogout:"+data);
        Uris.isLogin = false;
        Toast.makeText(getActivity(), "退出成功", Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction().replace(R.id.framelayout_main,new PersonFragment()).commit();
    }

    @Override
    public void success(String data) {

    }

    @Override
    public void failess(String message) {

    }

    public void receiveBus(){
        RxBus.getInstance().getObservable(String.class).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {


            }
        });
    }

}
