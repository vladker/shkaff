package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class OpenBluetoothDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f2622a;

    @BindView(4919)
    TextView mBtnCancel;

    @BindView(4920)
    TextView mBtnConfirm;

    public OpenBluetoothDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        setContentView(p113u.e.dialog_open_bluetooth);
        ButterKnife.bind(this);
    }

    @OnClick({4919, 4920})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_cancel) {
            z zVar = this.f2622a;
            if (zVar != null) {
                zVar.onCancel();
            }
            dismiss();
            return;
        }
        if (view.getId() == p113u.d.btn_confirm) {
            z zVar2 = this.f2622a;
            if (zVar2 != null) {
                zVar2.onConfirm();
            }
            dismiss();
        }
    }
}
