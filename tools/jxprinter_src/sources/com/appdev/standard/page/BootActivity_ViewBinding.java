package com.appdev.standard.page;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BootActivity_ViewBinding implements Unbinder {
    private BootActivity target;

    @UiThread
    public BootActivity_ViewBinding(BootActivity bootActivity) {
        this(bootActivity, bootActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BootActivity bootActivity = this.target;
        if (bootActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bootActivity.ivBootContent = null;
    }

    @UiThread
    public BootActivity_ViewBinding(BootActivity bootActivity, View view) {
        this.target = bootActivity;
        bootActivity.ivBootContent = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_boot_content, "field 'ivBootContent'", ImageView.class);
    }
}
