package com.appdev.standard.page.auth;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PcLoginConfirmActivity_ViewBinding implements Unbinder {
    private PcLoginConfirmActivity target;

    @UiThread
    public PcLoginConfirmActivity_ViewBinding(PcLoginConfirmActivity pcLoginConfirmActivity) {
        this(pcLoginConfirmActivity, pcLoginConfirmActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PcLoginConfirmActivity pcLoginConfirmActivity = this.target;
        if (pcLoginConfirmActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        pcLoginConfirmActivity.btnConfirm = null;
        pcLoginConfirmActivity.btnCancel = null;
    }

    @UiThread
    public PcLoginConfirmActivity_ViewBinding(PcLoginConfirmActivity pcLoginConfirmActivity, View view) {
        this.target = pcLoginConfirmActivity;
        pcLoginConfirmActivity.btnConfirm = (Button) d.findRequiredViewAsType(view, p113u.d.btn_pc_login_confirm, "field 'btnConfirm'", Button.class);
        pcLoginConfirmActivity.btnCancel = (Button) d.findRequiredViewAsType(view, p113u.d.btn_pc_login_cancel, "field 'btnCancel'", Button.class);
    }
}
