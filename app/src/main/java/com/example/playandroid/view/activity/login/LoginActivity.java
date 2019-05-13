package com.example.playandroid.view.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playandroid.MainActivity;
import com.example.playandroid.R;
import com.example.playandroid.base.MVPActivity;
import com.example.playandroid.model.uri.Uris;
import com.example.playandroid.persenter.login.LoginPresenter;
import com.example.playandroid.persenter.login.LoginView;
import com.example.playandroid.utils.SPUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 15:33
 * Describe: ${as}
 */
public class LoginActivity extends MVPActivity<LoginPresenter, LoginView, String> implements LoginView {
    @BindView(R.id.back_loginactivity)
    ImageView backLoginactivity;
    @BindView(R.id.name_loginactivity)
    TextView nameLoginactivity;
    @BindView(R.id.edit_username_loginactivity)
    EditText editUsernameLoginactivity;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.edit_repwd)
    EditText editRepwd;
    @BindView(R.id.linear_loginavtivity)
    LinearLayout linearLoginavtivity;
    @BindView(R.id.btn_login_loginactivity)
    Button btnLoginLoginactivity;
    @BindView(R.id.btn_register_loginactivity)
    Button btnRegisterLoginactivity;
    @BindView(R.id.msg_loginactivity)
    TextView msgLoginactivity;
    @BindView(R.id.msg_riger_loginactivity)
    TextView msgRigerLoginactivity;
    private boolean flag = false;
    private String username;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
    }

    private void initListener() {
        msgLoginactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = true;
                nameLoginactivity.setText("注册");
                editRepwd.setVisibility(View.VISIBLE);
                btnLoginLoginactivity.setVisibility(View.GONE);
                btnRegisterLoginactivity.setVisibility(View.VISIBLE);
                msgLoginactivity.setVisibility(View.GONE);
                msgRigerLoginactivity.setVisibility(View.VISIBLE);

            }
        });
        msgRigerLoginactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                nameLoginactivity.setText("登录");
                editRepwd.setVisibility(View.GONE);
                btnRegisterLoginactivity.setVisibility(View.GONE);
                btnLoginLoginactivity.setVisibility(View.VISIBLE);
                msgLoginactivity.setVisibility(View.VISIBLE);
                msgRigerLoginactivity.setVisibility(View.GONE);

            }
        });
        backLoginactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
        btnLoginLoginactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                username = editUsernameLoginactivity.getText().toString();
                String password = editPwd.getText().toString();
                if(username.length()<6||password.length()<6){
                    Toast.makeText(LoginActivity.this, "用户名或密码不能少于6位", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    presenter.postLogin(username,password);
                }
            }
        });
        btnRegisterLoginactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = editUsernameLoginactivity.getText().toString();
                String password = editPwd.getText().toString();
                String repassword = editRepwd.getText().toString();
                if(!password.equals(repassword)){
                    Toast.makeText(LoginActivity.this, "两次密码不一样", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    if(username.length()<6||password.length()<6){
                        Toast.makeText(LoginActivity.this, "用户名或密码不能少于6位", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        presenter.postRegister(username,password,repassword);
                    }
                }

            }
        });
    }

    @Override
    public void success(String data) {

    }


    @Override
    public void failess(String message) {

    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void successLogin(String data) {
        Log.i("guochao","successLogin"+data);
        int errorCode = 0;
        String errorMsg = "";
        try {
            JSONObject jsonObject = new JSONObject(data);
            errorCode = jsonObject.getInt("errorCode");
            errorMsg = jsonObject.getString("errorMsg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(errorCode==-1){
            Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            Uris.isLogin = true;
            Uris.user = username;
            Intent intent = new Intent(this, MainActivity.class);
            SPUtils.getInstance().setStringSp("islogin","1");
            startActivity(intent);
            this.finish();
        }
    }

    @Override
    public void successRegister(String data) {
        Log.i("guochao","successRegister"+data);
        int errorCode = 0;
        String errorMsg = "";
        try {
            JSONObject jsonObject = new JSONObject(data);
            errorCode = jsonObject.getInt("errorCode");
            errorMsg = jsonObject.getString("errorMsg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(errorCode==-1){
            Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void successLogout(String data) {

    }
}
