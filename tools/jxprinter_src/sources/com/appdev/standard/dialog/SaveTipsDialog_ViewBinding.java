package com.appdev.standard.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SaveTipsDialog_ViewBinding implements Unbinder {
    public SaveTipsDialog b;
    public View c;
    public View d;
    public View e;

    @UiThread
    public SaveTipsDialog_ViewBinding(SaveTipsDialog saveTipsDialog) {
        this(saveTipsDialog, saveTipsDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SaveTipsDialog saveTipsDialog = this.b;
        if (saveTipsDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        saveTipsDialog.mTvDialogContent = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
    }

    @UiThread
    public SaveTipsDialog_ViewBinding(SaveTipsDialog saveTipsDialog, View view) {
        this.b = saveTipsDialog;
        saveTipsDialog.mTvDialogContent = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_dialog_content, "field 'mTvDialogContent'", TextView.class);
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.btn_cancel, "method 'onBtnClick'");
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new D(saveTipsDialog, 0));
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.btn_confirm, "method 'onBtnClick'");
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new D(saveTipsDialog, 1));
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_dialog_close, "method 'onBtnClick'");
        this.e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new D(saveTipsDialog, 2));
    }
}
