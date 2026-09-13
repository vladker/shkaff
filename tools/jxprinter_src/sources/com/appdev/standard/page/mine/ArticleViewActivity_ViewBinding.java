package com.appdev.standard.page.mine;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ArticleViewActivity_ViewBinding implements Unbinder {
    private ArticleViewActivity target;

    @UiThread
    public ArticleViewActivity_ViewBinding(ArticleViewActivity articleViewActivity) {
        this(articleViewActivity, articleViewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ArticleViewActivity articleViewActivity = this.target;
        if (articleViewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        articleViewActivity.mTvTitle = null;
        articleViewActivity.mWvContent = null;
    }

    @UiThread
    public ArticleViewActivity_ViewBinding(ArticleViewActivity articleViewActivity, View view) {
        this.target = articleViewActivity;
        articleViewActivity.mTvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'mTvTitle'", TextView.class);
        articleViewActivity.mWvContent = (WebView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.wv_content, "field 'mWvContent'", WebView.class);
    }
}
