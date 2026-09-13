package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.ProgressBar;

/* JADX INFO: renamed from: com.appdev.standard.dialog.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class DialogC0464q extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressBar f2653a;

    public DialogC0464q(Context context) {
        super(context, p113u.h.Dialog);
        this.f2653a = null;
        setContentView(p113u.e.dialog_font_download_progress);
        setCanceledOnTouchOutside(false);
        this.f2653a = (ProgressBar) findViewById(p113u.d.pb_download);
    }

    public final void a(int i5) {
        ProgressBar progressBar = this.f2653a;
        if (progressBar == null) {
            return;
        }
        progressBar.setProgress(i5);
    }
}
