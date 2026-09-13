package com.appdev.standard.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class InvitationNotificationTipDialog_ViewBinding implements Unbinder {
    public InvitationNotificationTipDialog b;
    public View c;
    public View d;

    @UiThread
    public InvitationNotificationTipDialog_ViewBinding(InvitationNotificationTipDialog invitationNotificationTipDialog) {
        this(invitationNotificationTipDialog, invitationNotificationTipDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        InvitationNotificationTipDialog invitationNotificationTipDialog = this.b;
        if (invitationNotificationTipDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        invitationNotificationTipDialog.mTvDialogTitle = null;
        invitationNotificationTipDialog.mTvDialogContent = null;
        invitationNotificationTipDialog.mBtnCancel = null;
        invitationNotificationTipDialog.mBtnConfirm = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }

    @UiThread
    public InvitationNotificationTipDialog_ViewBinding(InvitationNotificationTipDialog invitationNotificationTipDialog, View view) {
        this.b = invitationNotificationTipDialog;
        invitationNotificationTipDialog.mTvDialogTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_dialog_title, "field 'mTvDialogTitle'", TextView.class);
        invitationNotificationTipDialog.mTvDialogContent = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_dialog_content, "field 'mTvDialogContent'", TextView.class);
        int i5 = p113u.d.btn_cancel;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'mBtnCancel' and method 'onBtnClick'");
        invitationNotificationTipDialog.mBtnCancel = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'mBtnCancel'", TextView.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new C0467u(invitationNotificationTipDialog, 0));
        int i6 = p113u.d.btn_confirm;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'mBtnConfirm' and method 'onBtnClick'");
        invitationNotificationTipDialog.mBtnConfirm = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'mBtnConfirm'", TextView.class);
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new C0467u(invitationNotificationTipDialog, 1));
    }
}
