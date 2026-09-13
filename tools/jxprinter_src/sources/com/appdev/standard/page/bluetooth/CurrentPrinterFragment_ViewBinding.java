package com.appdev.standard.page.bluetooth;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CurrentPrinterFragment_ViewBinding implements Unbinder {
    private CurrentPrinterFragment target;

    @UiThread
    public CurrentPrinterFragment_ViewBinding(CurrentPrinterFragment currentPrinterFragment, View view) {
        this.target = currentPrinterFragment;
        currentPrinterFragment.tvPrintPrintName = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_print_name, "field 'tvPrintPrintName'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CurrentPrinterFragment currentPrinterFragment = this.target;
        if (currentPrinterFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        currentPrinterFragment.tvPrintPrintName = null;
    }
}
