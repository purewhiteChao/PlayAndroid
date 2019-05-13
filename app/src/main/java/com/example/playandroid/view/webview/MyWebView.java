package com.example.playandroid.view.webview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/12 0012
 * Time: 19:13
 * Describe: ${as}
 */
public class MyWebView extends BaseActivity {

    @BindView(R.id.progressbar_mywebview)
    ProgressBar progressbarMywebview;
    @BindView(R.id.toolbar_mywebview)
    Toolbar toolbarMywebview;
    @BindView(R.id.back_myvebview)
    ImageView backMyvebview;
    @BindView(R.id.title_myvebview)
    TextView titleMyvebview;
    private String url;
    @BindView(R.id.webview_mywebview)
    WebView webviewMywebview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        initView();
        initListener();
    }

    private void initListener() {

        backMyvebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webviewMywebview!=null){
                    webviewMywebview.destroy();
                }

                MyWebView.this.finish();
            }
        });
    }

    private void initView() {
        webviewMywebview.loadUrl(url);
        WebSettings settings = webviewMywebview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportZoom(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webviewMywebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webviewMywebview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                progressbarMywebview.setProgress(newProgress);
                if (progressbarMywebview.getProgress() == 100) {
                    progressbarMywebview.setVisibility(View.GONE);
                } else {
                    progressbarMywebview.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                titleMyvebview.setText(title);
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_webview;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(webviewMywebview!=null){
            webviewMywebview.destroy();
        }

    }
}
