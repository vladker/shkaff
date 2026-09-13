package com.appdev.standard.dialog;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ServerSwitchDialog_ViewBinding implements Unbinder {
    public ServerSwitchDialog b;
    public View c;
    public View d;

    @UiThread
    public ServerSwitchDialog_ViewBinding(ServerSwitchDialog serverSwitchDialog) {
        this(serverSwitchDialog, serverSwitchDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ServerSwitchDialog serverSwitchDialog = this.b;
        if (serverSwitchDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        serverSwitchDialog.mTvDialogTitle = null;
        serverSwitchDialog.mEtServerIp = null;
        serverSwitchDialog.mEtServerPort = null;
        serverSwitchDialog.mBtnCancel = null;
        serverSwitchDialog.mBtnConfirm = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }

    @UiThread
    public ServerSwitchDialog_ViewBinding(ServerSwitchDialog serverSwitchDialog, View view) {
        this.b = serverSwitchDialog;
        serverSwitchDialog.mTvDialogTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_dialog_title, "field 'mTvDialogTitle'", TextView.class);
        serverSwitchDialog.mEtServerIp = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_server_ip, "field 'mEtServerIp'", EditText.class);
        serverSwitchDialog.mEtServerPort = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_server_port, "field 'mEtServerPort'", EditText.class);
        int i5 = p113u.d.btn_cancel;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'mBtnCancel' and method 'onBtnClick'");
        serverSwitchDialog.mBtnCancel = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'mBtnCancel'", TextView.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new F(serverSwitchDialog, 0));
        int i6 = p113u.d.btn_confirm;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'mBtnConfirm' and method 'onBtnClick'");
        serverSwitchDialog.mBtnConfirm = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'mBtnConfirm'", TextView.class);
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new F(serverSwitchDialog, 1));
    }
}
