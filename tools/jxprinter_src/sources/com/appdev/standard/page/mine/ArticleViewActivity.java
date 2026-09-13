package com.appdev.standard.page.mine;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.MvpActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_ARTICLE_VIEW)
public class ArticleViewActivity extends MvpActivity {
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    private View customView;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private FrameLayout fullscreenContainer;

    @BindView(6274)
    TextView mTvTitle;

    @BindView(6327)
    WebView mWvContent;

    @Autowired(name = "title")
    String title;

    @Autowired(name = "url")
    String url;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FullscreenHolder extends FrameLayout {
        public FullscreenHolder(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(R.color.black));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.customView == null) {
            return;
        }
        setStatusBarVisibility(true);
        ((FrameLayout) getWindow().getDecorView()).removeView(this.fullscreenContainer);
        this.fullscreenContainer = null;
        this.customView = null;
        this.customViewCallback.onCustomViewHidden();
        this.mWvContent.setVisibility(0);
    }

    private void setStatusBarVisibility(boolean z6) {
        getWindow().setFlags(z6 ? 0 : 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.customView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        getWindow().getDecorView();
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        FullscreenHolder fullscreenHolder = new FullscreenHolder(this);
        this.fullscreenContainer = fullscreenHolder;
        FrameLayout.LayoutParams layoutParams = COVER_SCREEN_PARAMS;
        fullscreenHolder.addView(view, layoutParams);
        frameLayout.addView(this.fullscreenContainer, layoutParams);
        this.customView = view;
        setStatusBarVisibility(false);
        this.customViewCallback = customViewCallback;
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mTvTitle.setText(this.title);
        initWebView(this.url);
        System.out.println(this.url);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    public void initWebView(String str) {
        WebChromeClient webChromeClient = new WebChromeClient();
        WebSettings settings = this.mWvContent.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(2);
        settings.setMediaPlaybackRequiresUserGesture(false);
        this.mWvContent.setWebChromeClient(webChromeClient);
        this.mWvContent.setWebViewClient(new WebViewClient() { // from class: com.appdev.standard.page.mine.ArticleViewActivity.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                ArticleViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                return true;
            }
        });
        this.mWvContent.setWebChromeClient(new WebChromeClient() { // from class: com.appdev.standard.page.mine.ArticleViewActivity.2
            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                FrameLayout frameLayout = new FrameLayout(ArticleViewActivity.this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                return frameLayout;
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                ArticleViewActivity.this.hideCustomView();
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                ArticleViewActivity.this.showCustomView(view, customViewCallback);
            }
        });
        this.mWvContent.loadUrl(str);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_article_view;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i5, KeyEvent keyEvent) {
        if (i5 != 4) {
            return super.onKeyUp(i5, keyEvent);
        }
        if (this.customView != null) {
            hideCustomView();
            return true;
        }
        finish();
        return true;
    }
}
