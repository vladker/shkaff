package com.appdev.standard.page.receipt;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptEditActivity_ViewBinding implements Unbinder {
    private ReceiptEditActivity target;

    @UiThread
    public ReceiptEditActivity_ViewBinding(ReceiptEditActivity receiptEditActivity) {
        this(receiptEditActivity, receiptEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ReceiptEditActivity receiptEditActivity = this.target;
        if (receiptEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        receiptEditActivity.tvTitle = null;
        receiptEditActivity.rvReceiptEditData = null;
        receiptEditActivity.llReceiptEdit = null;
        receiptEditActivity.ivDelete = null;
        receiptEditActivity.nsvReceiptEdit = null;
    }

    @UiThread
    public ReceiptEditActivity_ViewBinding(ReceiptEditActivity receiptEditActivity, View view) {
        this.target = receiptEditActivity;
        receiptEditActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        receiptEditActivity.rvReceiptEditData = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_receipt_edit_data, "field 'rvReceiptEditData'", RecyclerView.class);
        receiptEditActivity.llReceiptEdit = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_receipt_edit, "field 'llReceiptEdit'", LinearLayout.class);
        receiptEditActivity.ivDelete = (ImageView) d.findRequiredViewAsType(view, p113u.d.iv_delete, "field 'ivDelete'", ImageView.class);
        receiptEditActivity.nsvReceiptEdit = (NestedScrollView) d.findRequiredViewAsType(view, p113u.d.nsv_receipt_edit, "field 'nsvReceiptEdit'", NestedScrollView.class);
    }
}
