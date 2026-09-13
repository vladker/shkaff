package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kotlin.jvm.internal.Y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultEdittextDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0455h f2607a;

    @BindView(4919)
    TextView mBtnCancel;

    @BindView(4920)
    TextView mBtnConfirm;

    @BindView(5051)
    EditText mEtDialogContent;

    @BindView(6067)
    TextView mTvDialogTitle;

    public DefaultEdittextDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        setContentView(p113u.e.dialog_default_edittext);
        ButterKnife.bind(this);
    }

    public final void a(String str) {
        this.mBtnCancel.setText(str);
    }

    public final void b(String str) {
        this.mBtnConfirm.setText(str);
    }

    public final void c(String str) {
        this.mEtDialogContent.setText(str);
        EditText editText = this.mEtDialogContent;
        editText.setSelection(editText.getText().length());
    }

    public final void d(String str) {
        this.mEtDialogContent.setHint(str);
    }

    public final void e(String str) {
        if (Y.f(str)) {
            this.mTvDialogTitle.setVisibility(8);
        } else {
            this.mTvDialogTitle.setText(str);
            this.mTvDialogTitle.setVisibility(0);
        }
    }

    @OnClick({4919, 4920})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_cancel) {
            InterfaceC0455h interfaceC0455h = this.f2607a;
            if (interfaceC0455h != null) {
                interfaceC0455h.onCancel();
            }
            dismiss();
            return;
        }
        if (view.getId() == p113u.d.btn_confirm) {
            InterfaceC0455h interfaceC0455h2 = this.f2607a;
            if (interfaceC0455h2 != null) {
                interfaceC0455h2.onConfirm(this.mEtDialogContent.getText().toString().trim());
            }
            dismiss();
        }
    }
}
