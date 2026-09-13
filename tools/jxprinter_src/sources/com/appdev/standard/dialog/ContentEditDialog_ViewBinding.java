package com.appdev.standard.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ContentEditDialog_ViewBinding implements Unbinder {
    public ContentEditDialog b;
    public View c;
    public View d;

    @UiThread
    public ContentEditDialog_ViewBinding(ContentEditDialog contentEditDialog) {
        this(contentEditDialog, contentEditDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ContentEditDialog contentEditDialog = this.b;
        if (contentEditDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        contentEditDialog.mEtContent = null;
        contentEditDialog.mBtnConfirm = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }

    @UiThread
    public ContentEditDialog_ViewBinding(ContentEditDialog contentEditDialog, View view) {
        this.b = contentEditDialog;
        contentEditDialog.mEtContent = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_content, "field 'mEtContent'", EditText.class);
        int i5 = p113u.d.btn_confirm;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'mBtnConfirm' and method 'onConfirmClick'");
        contentEditDialog.mBtnConfirm = (Button) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'mBtnConfirm'", Button.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new C0454g(contentEditDialog, 0));
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.layout_root, "method 'onRootClick'");
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new C0454g(contentEditDialog, 1));
    }
}
