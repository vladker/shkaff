package com.appdev.standard.page.bluetooth;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterExceptionFragment_ViewBinding implements Unbinder {
    private PrinterExceptionFragment target;

    @UiThread
    public PrinterExceptionFragment_ViewBinding(PrinterExceptionFragment printerExceptionFragment, View view) {
        this.target = printerExceptionFragment;
        printerExceptionFragment.ll_printer_exception = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_printer_exception, "field 'll_printer_exception'", LinearLayout.class);
        printerExceptionFragment.ll_out_of_paper = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_printer_out_of_paper, "field 'll_out_of_paper'", LinearLayout.class);
        printerExceptionFragment.ll_open_the_lid = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_printer_open_the_lid, "field 'll_open_the_lid'", LinearLayout.class);
        printerExceptionFragment.ll_over_heart = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_printer_over_heart, "field 'll_over_heart'", LinearLayout.class);
        printerExceptionFragment.ll_cutter_error = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_printer_cutter_error, "field 'll_cutter_error'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PrinterExceptionFragment printerExceptionFragment = this.target;
        if (printerExceptionFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        printerExceptionFragment.ll_printer_exception = null;
        printerExceptionFragment.ll_out_of_paper = null;
        printerExceptionFragment.ll_open_the_lid = null;
        printerExceptionFragment.ll_over_heart = null;
        printerExceptionFragment.ll_cutter_error = null;
    }
}
