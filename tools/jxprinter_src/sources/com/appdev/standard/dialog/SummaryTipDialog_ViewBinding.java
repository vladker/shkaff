package com.appdev.standard.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SummaryTipDialog_ViewBinding implements Unbinder {
    public SummaryTipDialog b;
    public View c;
    public View d;

    @UiThread
    public SummaryTipDialog_ViewBinding(SummaryTipDialog summaryTipDialog) {
        this(summaryTipDialog, summaryTipDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SummaryTipDialog summaryTipDialog = this.b;
        if (summaryTipDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        summaryTipDialog.mTvDialogContent2 = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }

    @UiThread
    public SummaryTipDialog_ViewBinding(SummaryTipDialog summaryTipDialog, View view) {
        this.b = summaryTipDialog;
        summaryTipDialog.mTvDialogContent2 = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_dialog_content_2, "field 'mTvDialogContent2'", TextView.class);
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.btn_cancel, "method 'onBtnClick'");
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new L(summaryTipDialog, 0));
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.btn_confirm, "method 'onBtnClick'");
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new L(summaryTipDialog, 1));
    }
}
