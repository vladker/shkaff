package com.appdev.standard.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CommonContentEditDialog_ViewBinding implements Unbinder {
    public CommonContentEditDialog b;
    public View c;
    public View d;

    @UiThread
    public CommonContentEditDialog_ViewBinding(CommonContentEditDialog commonContentEditDialog) {
        this(commonContentEditDialog, commonContentEditDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CommonContentEditDialog commonContentEditDialog = this.b;
        if (commonContentEditDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        commonContentEditDialog.mEtContent = null;
        commonContentEditDialog.mBtnConfirm = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }

    @UiThread
    public CommonContentEditDialog_ViewBinding(CommonContentEditDialog commonContentEditDialog, View view) {
        this.b = commonContentEditDialog;
        commonContentEditDialog.mEtContent = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_content, "field 'mEtContent'", EditText.class);
        int i5 = p113u.d.btn_confirm;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'mBtnConfirm' and method 'onConfirmClick'");
        commonContentEditDialog.mBtnConfirm = (Button) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'mBtnConfirm'", Button.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new C0449b(commonContentEditDialog, 0));
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.layout_root, "method 'onRootClick'");
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new C0449b(commonContentEditDialog, 1));
    }
}
