package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CommonContentEditDialog extends Dialog {

    @BindView(4920)
    Button mBtnConfirm;

    @BindView(5045)
    EditText mEtContent;

    public CommonContentEditDialog(@NonNull Context context) {
        this(context, false);
    }

    @OnClick({4920})
    public void onConfirmClick(View view) {
        ((InputMethodManager) this.mEtContent.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mEtContent.getWindowToken(), 0);
        dismiss();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(18);
    }

    @OnClick({5315})
    public void onRootClick(View view) {
        dismiss();
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
        this.mEtContent.postDelayed(new RunnableC0448a(this, 0), 100L);
    }

    public CommonContentEditDialog(@NonNull Context context, boolean z6) {
        super(context, p113u.h.Dialog);
        setContentView(p113u.e.dialog_common_content_edit);
        ButterKnife.bind(this);
        if (z6) {
            this.mEtContent.setInputType(2);
        }
    }
}
