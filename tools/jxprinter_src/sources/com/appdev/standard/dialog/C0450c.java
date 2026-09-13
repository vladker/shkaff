package com.appdev.standard.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: com.appdev.standard.dialog.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0450c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0451d f2639a;

    public C0450c(Context context) {
        C0451d c0451d = new C0451d();
        c0451d.d = true;
        c0451d.f2643h = false;
        c0451d.f2640a = context;
        this.f2639a = c0451d;
    }

    public final C0451d a() {
        C0451d c0451d = this.f2639a;
        if (c0451d.e == null) {
            c0451d.e = LayoutInflater.from(c0451d.f2640a).inflate(-1, (ViewGroup) null);
        }
        Activity activity = (Activity) c0451d.e.getContext();
        if (activity != null && c0451d.f2643h) {
            Window window = activity.getWindow();
            c0451d.f2642g = window;
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 0.7f;
            c0451d.f2642g.addFlags(2);
            c0451d.f2642g.setAttributes(attributes);
        }
        if (c0451d.b == 0 || c0451d.c == 0) {
            c0451d.f2641f = new PopupWindow(c0451d.e, -2, -2);
        } else {
            c0451d.f2641f = new PopupWindow(c0451d.e, c0451d.b, c0451d.c);
        }
        PopupWindow popupWindow = c0451d.f2641f;
        popupWindow.setClippingEnabled(true);
        popupWindow.setTouchable(true);
        if (c0451d.b == 0 || c0451d.c == 0) {
            c0451d.f2641f.getContentView().measure(0, 0);
            c0451d.b = c0451d.f2641f.getContentView().getMeasuredWidth();
            c0451d.c = c0451d.f2641f.getContentView().getMeasuredHeight();
        }
        c0451d.f2641f.setOnDismissListener(c0451d);
        c0451d.f2641f.setFocusable(true);
        c0451d.f2641f.setBackgroundDrawable(new ColorDrawable(0));
        c0451d.f2641f.setOutsideTouchable(c0451d.d);
        c0451d.f2641f.update();
        return c0451d;
    }

    public final void b(int i5) {
        C0451d c0451d = this.f2639a;
        c0451d.b = -1;
        c0451d.c = i5;
    }
}
