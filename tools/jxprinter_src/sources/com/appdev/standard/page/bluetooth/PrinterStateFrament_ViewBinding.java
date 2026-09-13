package com.appdev.standard.page.bluetooth;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterStateFrament_ViewBinding implements Unbinder {
    private PrinterStateFrament target;

    @UiThread
    public PrinterStateFrament_ViewBinding(PrinterStateFrament printerStateFrament, View view) {
        this.target = printerStateFrament;
        printerStateFrament.tvFragmentIndexPrinterState = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_printer_state, "field 'tvFragmentIndexPrinterState'", TextView.class);
        printerStateFrament.ivFragmentIndexPrinterState = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_fragment_printer_state, "field 'ivFragmentIndexPrinterState'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PrinterStateFrament printerStateFrament = this.target;
        if (printerStateFrament == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        printerStateFrament.tvFragmentIndexPrinterState = null;
        printerStateFrament.ivFragmentIndexPrinterState = null;
    }
}
