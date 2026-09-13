package com.appdev.standard.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class OpenBluetoothDialog_ViewBinding implements Unbinder {
    public OpenBluetoothDialog b;
    public View c;
    public View d;

    @UiThread
    public OpenBluetoothDialog_ViewBinding(OpenBluetoothDialog openBluetoothDialog) {
        this(openBluetoothDialog, openBluetoothDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OpenBluetoothDialog openBluetoothDialog = this.b;
        if (openBluetoothDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        openBluetoothDialog.mBtnCancel = null;
        openBluetoothDialog.mBtnConfirm = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }

    @UiThread
    public OpenBluetoothDialog_ViewBinding(OpenBluetoothDialog openBluetoothDialog, View view) {
        this.b = openBluetoothDialog;
        int i5 = p113u.d.btn_cancel;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'mBtnCancel' and method 'onBtnClick'");
        openBluetoothDialog.mBtnCancel = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'mBtnCancel'", TextView.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new A(openBluetoothDialog, 0));
        int i6 = p113u.d.btn_confirm;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'mBtnConfirm' and method 'onBtnClick'");
        openBluetoothDialog.mBtnConfirm = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'mBtnConfirm'", TextView.class);
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new A(openBluetoothDialog, 1));
    }
}
