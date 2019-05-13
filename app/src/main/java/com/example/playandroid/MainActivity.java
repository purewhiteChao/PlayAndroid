package com.example.playandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.utils.SPUtils;
import com.example.playandroid.view.fragment.home.HomeFragment;
import com.example.playandroid.view.fragment.person.PersonFragment;
import com.example.playandroid.view.fragment.project.ProjectFragment;
import com.example.playandroid.view.fragment.system.SystemFragment;
import com.example.playandroid.view.fragment.wx.WxFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.edittext_main)
    EditText edittextMain;
    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;
    @BindView(R.id.bottomnavigation_main)
    BottomNavigationView bottomnavigationMain;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        String islogin = SPUtils.getInstance().getStringSp("islogin", "0");
        if(islogin.equals("1")){
            SPUtils.getInstance().removeStringSp("islogin");
            bottomnavigationMain.setSelectedItemId(R.id.person_menu);
        }else{
            bottomnavigationMain.setSelectedItemId(R.id.home_menu);

        }

    }

    private void initData() {
        bottomnavigationMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getTitle().equals("首页")){

                    replaceFragment(new HomeFragment());

                }else if(menuItem.getTitle().equals("知识体系")){

                    replaceFragment(new SystemFragment());
                }else if(menuItem.getTitle().equals("公众号")){

                    replaceFragment(new WxFragment());
                }else if(menuItem.getTitle().equals("项目")){
                    replaceFragment(new ProjectFragment());
                }else if(menuItem.getTitle().equals("我的")){

                    replaceFragment(new PersonFragment());
                }
                return true;
            }
        });
    }

    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_main,fragment).commit();
    }
}


