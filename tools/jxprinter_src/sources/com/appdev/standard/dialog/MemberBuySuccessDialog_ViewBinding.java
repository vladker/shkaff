package com.appdev.standard.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MemberBuySuccessDialog_ViewBinding implements Unbinder {
    public MemberBuySuccessDialog b;
    public View c;

    @UiThread
    public MemberBuySuccessDialog_ViewBinding(MemberBuySuccessDialog memberBuySuccessDialog) {
        this(memberBuySuccessDialog, memberBuySuccessDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MemberBuySuccessDialog memberBuySuccessDialog = this.b;
        if (memberBuySuccessDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        memberBuySuccessDialog.btnFinish = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }

    @UiThread
    public MemberBuySuccessDialog_ViewBinding(MemberBuySuccessDialog memberBuySuccessDialog, View view) {
        this.b = memberBuySuccessDialog;
        int i5 = p113u.d.btn_finish;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'btnFinish' and method 'onBtnClick'");
        memberBuySuccessDialog.btnFinish = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'btnFinish'", TextView.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new C0466t(memberBuySuccessDialog, 1));
    }
}
