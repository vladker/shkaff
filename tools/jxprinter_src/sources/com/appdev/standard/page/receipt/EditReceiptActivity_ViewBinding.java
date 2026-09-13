package com.appdev.standard.page.receipt;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class EditReceiptActivity_ViewBinding implements Unbinder {
    private EditReceiptActivity target;

    @UiThread
    public EditReceiptActivity_ViewBinding(EditReceiptActivity editReceiptActivity) {
        this(editReceiptActivity, editReceiptActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditReceiptActivity editReceiptActivity = this.target;
        if (editReceiptActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        editReceiptActivity.tvTitle = null;
        editReceiptActivity.rgWidth = null;
    }

    @UiThread
    public EditReceiptActivity_ViewBinding(EditReceiptActivity editReceiptActivity, View view) {
        this.target = editReceiptActivity;
        editReceiptActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        editReceiptActivity.rgWidth = (RadioGroup) d.findRequiredViewAsType(view, p113u.d.rg_width, "field 'rgWidth'", RadioGroup.class);
    }
}
