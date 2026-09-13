package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LogoffTipDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0468v f2617a;

    public LogoffTipDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        this.f2617a = null;
        setContentView(p113u.e.dialog_logoff_tips);
        ButterKnife.bind(this);
    }

    @OnClick({4919, 4920})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_cancel) {
            InterfaceC0468v interfaceC0468v = this.f2617a;
            if (interfaceC0468v != null) {
                interfaceC0468v.onCancel();
            }
            dismiss();
            return;
        }
        if (view.getId() == p113u.d.btn_confirm) {
            InterfaceC0468v interfaceC0468v2 = this.f2617a;
            if (interfaceC0468v2 != null) {
                interfaceC0468v2.onConfirm();
            }
            dismiss();
        }
    }
}
