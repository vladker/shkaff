package com.appdev.standard.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PermissionTipDialog_ViewBinding implements Unbinder {
    public PermissionTipDialog b;
    public View c;
    public View d;

    @UiThread
    public PermissionTipDialog_ViewBinding(PermissionTipDialog permissionTipDialog) {
        this(permissionTipDialog, permissionTipDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PermissionTipDialog permissionTipDialog = this.b;
        if (permissionTipDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        permissionTipDialog.mTvDialogTitle = null;
        permissionTipDialog.mTvDialogContent = null;
        permissionTipDialog.mBtnCancel = null;
        permissionTipDialog.mBtnConfirm = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }

    @UiThread
    public PermissionTipDialog_ViewBinding(PermissionTipDialog permissionTipDialog, View view) {
        this.b = permissionTipDialog;
        permissionTipDialog.mTvDialogTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_dialog_title, "field 'mTvDialogTitle'", TextView.class);
        permissionTipDialog.mTvDialogContent = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_dialog_content, "field 'mTvDialogContent'", TextView.class);
        int i5 = p113u.d.btn_cancel;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'mBtnCancel' and method 'onBtnClick'");
        permissionTipDialog.mBtnCancel = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'mBtnCancel'", TextView.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new B(permissionTipDialog, 0));
        int i6 = p113u.d.btn_confirm;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'mBtnConfirm' and method 'onBtnClick'");
        permissionTipDialog.mBtnConfirm = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'mBtnConfirm'", TextView.class);
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new B(permissionTipDialog, 1));
    }
}
