package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kotlin.jvm.internal.Y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ContentEditDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2605a;
    public InterfaceC0453f b;

    @BindView(4920)
    Button mBtnConfirm;

    @BindView(5045)
    EditText mEtContent;

    public ContentEditDialog(@NonNull Context context) {
        this(context, 0);
    }

    public final void a(String str) {
        if (!Y.f(str)) {
            this.mEtContent.setText(str);
            this.mEtContent.setSelection(str.length());
        }
        this.mEtContent.addTextChangedListener(new C0452e(this));
        this.mEtContent.setSelectAllOnFocus(true);
    }

    @OnClick({4920})
    public void onConfirmClick(View view) {
        if (this.b != null) {
            this.b.setNewContent(this.mEtContent.getText().toString());
        }
        ((InputMethodManager) this.mEtContent.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mEtContent.getWindowToken(), 0);
        dismiss();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
            window.setGravity(17);
        }
        setCanceledOnTouchOutside(true);
    }

    @OnClick({5315})
    public void onRootClick(View view) {
        dismiss();
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
        this.mEtContent.postDelayed(new RunnableC0448a(this, 1), 100L);
    }

    public ContentEditDialog(@NonNull Context context, int i5) {
        super(context, p113u.h.Dialog);
        this.f2605a = false;
        setContentView(p113u.e.dialog_content_edit);
        ButterKnife.bind(this);
        if (i5 == 1) {
            this.f2605a = true;
            this.mEtContent.setInputType(1);
            this.mEtContent.setSingleLine(true);
            this.mEtContent.setMaxLines(1);
            return;
        }
        if (i5 == 2) {
            this.mEtContent.setInputType(2);
            this.mEtContent.setSingleLine(true);
            this.mEtContent.setMaxLines(1);
        } else if (i5 != 3) {
            this.mEtContent.setInputType(1);
            this.mEtContent.setSingleLine(true);
            this.mEtContent.setMaxLines(1);
        } else {
            this.mEtContent.setInputType(131072);
            this.mEtContent.setSingleLine(false);
            this.mEtContent.setMinLines(8);
            this.mEtContent.setGravity(48);
            this.mEtContent.setPadding(11, 11, 11, 11);
        }
    }
}
