package com.example.playandroid.view.activity.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;
import com.suke.widget.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 15:10
 * Describe: ${as}
 */
public class SettingActivity extends BaseActivity {
    @BindView(R.id.back_setting)
    ImageView backSetting;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.switch_night_setting)
    SwitchButton switchNightSetting;
    @BindView(R.id.switch_nopic_setting)
    SwitchButton switchNopicSetting;
    @BindView(R.id.switch_cache_setting)
    SwitchButton switchCacheSetting;
    @BindView(R.id.yijian_setting)
    TextView yijianSetting;
    @BindView(R.id.cleancache_setting)
    RelativeLayout cleancacheSetting;
    @BindView(R.id.version_setting)
    RelativeLayout versionSetting;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
    }

    private void initListener() {
        backSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingActivity.this.finish();
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_setting;
    }


}
