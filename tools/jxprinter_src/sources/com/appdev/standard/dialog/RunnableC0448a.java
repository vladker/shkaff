package com.appdev.standard.dialog;

import android.app.Dialog;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: renamed from: com.appdev.standard.dialog.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0448a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2637a;
    public final /* synthetic */ Dialog b;

    public /* synthetic */ RunnableC0448a(Dialog dialog, int i5) {
        this.f2637a = i5;
        this.b = dialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditText editText;
        EditText editText2;
        switch (this.f2637a) {
            case 0:
                CommonContentEditDialog commonContentEditDialog = (CommonContentEditDialog) this.b;
                InputMethodManager inputMethodManager = (InputMethodManager) commonContentEditDialog.mEtContent.getContext().getSystemService("input_method");
                if (inputMethodManager != null && (editText = commonContentEditDialog.mEtContent) != null) {
                    editText.requestFocus();
                    inputMethodManager.showSoftInput(commonContentEditDialog.mEtContent, 0);
                    break;
                }
                break;
            default:
                ContentEditDialog contentEditDialog = (ContentEditDialog) this.b;
                InputMethodManager inputMethodManager2 = (InputMethodManager) contentEditDialog.mEtContent.getContext().getSystemService("input_method");
                if (inputMethodManager2 != null && (editText2 = contentEditDialog.mEtContent) != null) {
                    editText2.requestFocus();
                    inputMethodManager2.showSoftInput(contentEditDialog.mEtContent, 0);
                    break;
                }
                break;
        }
    }
}
