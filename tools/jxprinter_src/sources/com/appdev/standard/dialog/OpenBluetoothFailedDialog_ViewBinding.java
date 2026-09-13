package com.appdev.standard.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class OpenBluetoothFailedDialog_ViewBinding implements Unbinder {
    public OpenBluetoothFailedDialog b;
    public View c;

    @UiThread
    public OpenBluetoothFailedDialog_ViewBinding(OpenBluetoothFailedDialog openBluetoothFailedDialog) {
        this(openBluetoothFailedDialog, openBluetoothFailedDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OpenBluetoothFailedDialog openBluetoothFailedDialog = this.b;
        if (openBluetoothFailedDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        openBluetoothFailedDialog.mBtnConfirm = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }

    @UiThread
    public OpenBluetoothFailedDialog_ViewBinding(OpenBluetoothFailedDialog openBluetoothFailedDialog, View view) {
        this.b = openBluetoothFailedDialog;
        int i5 = p113u.d.btn_confirm;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'mBtnConfirm' and method 'onBtnClick'");
        openBluetoothFailedDialog.mBtnConfirm = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'mBtnConfirm'", TextView.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new C0466t(openBluetoothFailedDialog, 2));
    }
}
