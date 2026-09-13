package com.appdev.standard.page.receipt;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.d;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptPrintPageActivity_ViewBinding implements Unbinder {
    private ReceiptPrintPageActivity target;

    @UiThread
    public ReceiptPrintPageActivity_ViewBinding(ReceiptPrintPageActivity receiptPrintPageActivity) {
        this(receiptPrintPageActivity, receiptPrintPageActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ReceiptPrintPageActivity receiptPrintPageActivity = this.target;
        if (receiptPrintPageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        receiptPrintPageActivity.tvTitle = null;
        receiptPrintPageActivity.qswReceiptPrintPagePrintCount = null;
        receiptPrintPageActivity.rvReceiptEditData = null;
    }

    @UiThread
    public ReceiptPrintPageActivity_ViewBinding(ReceiptPrintPageActivity receiptPrintPageActivity, View view) {
        this.target = receiptPrintPageActivity;
        receiptPrintPageActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        receiptPrintPageActivity.qswReceiptPrintPagePrintCount = (QuantitySelectorWidget) d.findRequiredViewAsType(view, p113u.d.qsw_receipt_print_page_print_count, "field 'qswReceiptPrintPagePrintCount'", QuantitySelectorWidget.class);
        receiptPrintPageActivity.rvReceiptEditData = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_receipt_edit_data, "field 'rvReceiptEditData'", RecyclerView.class);
    }
}
