package com.appdev.standard.dialog;

import android.app.Dialog;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.library.base.frame.MvpActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class y extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressBar f2659a;
    public final TextView b;

    public y(MvpActivity mvpActivity) {
        super(mvpActivity, p113u.h.Dialog);
        setContentView(p113u.e.dialog_model_download_progress);
        setCanceledOnTouchOutside(false);
        this.f2659a = (ProgressBar) findViewById(p113u.d.pb_download);
        this.b = (TextView) findViewById(p113u.d.tv_progress_percent);
    }

    public final void a(int i5) {
        ProgressBar progressBar = this.f2659a;
        if (progressBar != null) {
            progressBar.setProgress(i5);
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(i5 + "%");
        }
    }
}
