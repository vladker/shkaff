package com.appdev.standard.dialog;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ShareDialog_ViewBinding implements Unbinder {
    public ShareDialog b;
    public View c;
    public View d;
    public View e;

    @UiThread
    public ShareDialog_ViewBinding(ShareDialog shareDialog) {
        this(shareDialog, shareDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ShareDialog shareDialog = this.b;
        if (shareDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        shareDialog.mTvDialogTitle = null;
        shareDialog.mBtnCancel = null;
        shareDialog.llDialogShareWechat = null;
        shareDialog.llDialogShareLink = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
    }

    @UiThread
    public ShareDialog_ViewBinding(ShareDialog shareDialog, View view) {
        this.b = shareDialog;
        shareDialog.mTvDialogTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_dialog_title, "field 'mTvDialogTitle'", TextView.class);
        int i5 = p113u.d.btn_cancel;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'mBtnCancel' and method 'onBtnClick'");
        shareDialog.mBtnCancel = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'mBtnCancel'", TextView.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new H(shareDialog, 0));
        int i6 = p113u.d.ll_dialog_share_wechat;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'llDialogShareWechat' and method 'onBtnClick'");
        shareDialog.llDialogShareWechat = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'llDialogShareWechat'", LinearLayout.class);
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new H(shareDialog, 1));
        int i7 = p113u.d.ll_dialog_share_link;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'llDialogShareLink' and method 'onBtnClick'");
        shareDialog.llDialogShareLink = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'llDialogShareLink'", LinearLayout.class);
        this.e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new H(shareDialog, 2));
    }
}
