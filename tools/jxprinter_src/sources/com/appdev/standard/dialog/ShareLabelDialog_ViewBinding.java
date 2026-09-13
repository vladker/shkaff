package com.appdev.standard.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ShareLabelDialog_ViewBinding implements Unbinder {
    public ShareLabelDialog b;
    public View c;
    public View d;

    @UiThread
    public ShareLabelDialog_ViewBinding(ShareLabelDialog shareLabelDialog) {
        this(shareLabelDialog, shareLabelDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ShareLabelDialog shareLabelDialog = this.b;
        if (shareLabelDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        shareLabelDialog.ivDialogShareLabelImg = null;
        shareLabelDialog.btnEdit = null;
        shareLabelDialog.btnEditNo = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }

    @UiThread
    public ShareLabelDialog_ViewBinding(ShareLabelDialog shareLabelDialog, View view) {
        this.b = shareLabelDialog;
        shareLabelDialog.ivDialogShareLabelImg = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_dialog_share_label_img, "field 'ivDialogShareLabelImg'", ImageView.class);
        int i5 = p113u.d.btn_edit;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'btnEdit' and method 'onBtnClick'");
        shareLabelDialog.btnEdit = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'btnEdit'", TextView.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new J(shareLabelDialog, 0));
        int i6 = p113u.d.btn_edit_no;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'btnEditNo' and method 'onBtnClick'");
        shareLabelDialog.btnEditNo = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'btnEditNo'", TextView.class);
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new J(shareLabelDialog, 1));
    }
}
