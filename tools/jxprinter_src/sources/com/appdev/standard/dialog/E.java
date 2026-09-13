package com.appdev.standard.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class E extends Dialog {
    public static E c;
    public static Activity d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f2609a;
    public final ProgressBar b;

    public E(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        setContentView(p113u.e.dialog_send_progress);
        setCanceledOnTouchOutside(false);
        this.f2609a = (TextView) findViewById(p113u.d.tv_send_data_progress_percentage);
        this.b = (ProgressBar) findViewById(p113u.d.send_data_progress_bar);
    }

    public static void a() {
        E e = c;
        if (e == null || !e.isShowing()) {
            return;
        }
        try {
            c.dismiss();
            c = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void b(int i5) {
        E e = c;
        if (e == null) {
            return;
        }
        TextView textView = e.f2609a;
        ProgressBar progressBar = e.b;
        if (progressBar == null || textView == null) {
            return;
        }
        progressBar.setProgress(i5);
        textView.setText(i5 + "%");
    }

    public static void c() {
        V1.b.h().getClass();
        Activity activityD = V1.b.d();
        if (activityD == null) {
            return;
        }
        if (activityD != d) {
            d = activityD;
            E e = c;
            if (e != null && e.isShowing()) {
                try {
                    c.dismiss();
                } catch (Exception unused) {
                }
            }
            c = null;
        }
        if (c == null) {
            c = new E(activityD);
        }
        try {
            c.show();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
