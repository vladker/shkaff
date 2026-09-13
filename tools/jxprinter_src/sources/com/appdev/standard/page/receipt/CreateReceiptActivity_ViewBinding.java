package com.appdev.standard.page.receipt;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CreateReceiptActivity_ViewBinding implements Unbinder {
    private CreateReceiptActivity target;

    @UiThread
    public CreateReceiptActivity_ViewBinding(CreateReceiptActivity createReceiptActivity) {
        this(createReceiptActivity, createReceiptActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CreateReceiptActivity createReceiptActivity = this.target;
        if (createReceiptActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        createReceiptActivity.tvTitle = null;
        createReceiptActivity.rgWidth = null;
        createReceiptActivity.rb58 = null;
        createReceiptActivity.rb80 = null;
        createReceiptActivity.rb110 = null;
        createReceiptActivity.rb210 = null;
    }

    @UiThread
    public CreateReceiptActivity_ViewBinding(CreateReceiptActivity createReceiptActivity, View view) {
        this.target = createReceiptActivity;
        createReceiptActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        createReceiptActivity.rgWidth = (RadioGroup) d.findRequiredViewAsType(view, p113u.d.rg_width, "field 'rgWidth'", RadioGroup.class);
        createReceiptActivity.rb58 = (RadioButton) d.findRequiredViewAsType(view, p113u.d.rb_create_receipt_width_58, "field 'rb58'", RadioButton.class);
        createReceiptActivity.rb80 = (RadioButton) d.findRequiredViewAsType(view, p113u.d.rb_create_receipt_width_80, "field 'rb80'", RadioButton.class);
        createReceiptActivity.rb110 = (RadioButton) d.findRequiredViewAsType(view, p113u.d.rb_create_receipt_width_110, "field 'rb110'", RadioButton.class);
        createReceiptActivity.rb210 = (RadioButton) d.findRequiredViewAsType(view, p113u.d.rb_create_receipt_width_210, "field 'rb210'", RadioButton.class);
    }
}
