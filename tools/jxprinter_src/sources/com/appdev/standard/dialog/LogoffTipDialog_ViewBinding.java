package com.appdev.standard.dialog;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LogoffTipDialog_ViewBinding implements Unbinder {
    public LogoffTipDialog b;
    public View c;
    public View d;

    @UiThread
    public LogoffTipDialog_ViewBinding(LogoffTipDialog logoffTipDialog) {
        this(logoffTipDialog, logoffTipDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }

    @UiThread
    public LogoffTipDialog_ViewBinding(LogoffTipDialog logoffTipDialog, View view) {
        this.b = logoffTipDialog;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.btn_cancel, "method 'onBtnClick'");
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new w(logoffTipDialog, 0));
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.btn_confirm, "method 'onBtnClick'");
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new w(logoffTipDialog, 1));
    }
}
