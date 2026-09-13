package com.appdev.standard.dialog;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.appdev.standard.dialog.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0452e implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2644a = false;
    public final /* synthetic */ ContentEditDialog b;

    public C0452e(ContentEditDialog contentEditDialog) {
        this.b = contentEditDialog;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (this.b.f2605a && editable.length() > 0) {
            int i5 = 0;
            while (i5 <= editable.length() - 1) {
                int i6 = i5 + 1;
                if (!Pattern.matches("^[0-9a-zA-Z]*$", editable.subSequence(i5, i6))) {
                    this.f2644a = true;
                    editable.delete(i5, i6);
                    return;
                }
                i5 = i6;
            }
        }
        if (this.f2644a) {
            p042h2.d.show(p113u.g.toast_4);
            this.f2644a = false;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }
}
