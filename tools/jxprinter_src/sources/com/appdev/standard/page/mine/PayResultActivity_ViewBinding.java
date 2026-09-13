package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PayResultActivity_ViewBinding implements Unbinder {
    private PayResultActivity target;

    @UiThread
    public PayResultActivity_ViewBinding(PayResultActivity payResultActivity) {
        this(payResultActivity, payResultActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayResultActivity payResultActivity = this.target;
        if (payResultActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        payResultActivity.tvTitle = null;
        payResultActivity.ivPayStatus = null;
    }

    @UiThread
    public PayResultActivity_ViewBinding(PayResultActivity payResultActivity, View view) {
        this.target = payResultActivity;
        payResultActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        payResultActivity.ivPayStatus = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_pay_status, "field 'ivPayStatus'", ImageView.class);
    }
}
